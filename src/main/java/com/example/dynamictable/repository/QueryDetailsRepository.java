package com.example.dynamictable.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.example.dynamictable.model.QueryResultDetails;

@Repository
public class QueryDetailsRepository {
	final String SELECT_ALL_QUERY = "SELECT * from STUDENT";
	final String SELECT_NAME_QUERY = "SELECT name from STUDENT";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public QueryResultDetails getData(boolean getAllData) {
		String query = SELECT_NAME_QUERY;
		if (getAllData) {
			query = SELECT_ALL_QUERY;
		}
		return this.jdbcTemplate.query(query, new ResultSetExtractor<QueryResultDetails>() {

			@Override
			public QueryResultDetails extractData(ResultSet rs) throws SQLException, DataAccessException {
				QueryResultDetails queryDetails = new QueryResultDetails();
				List<String> list = new ArrayList<String>();
				List<String> columnNames = new ArrayList<>();
				while (rs.next()) {

					StringBuffer rowData = new StringBuffer();
					int numberOfColumns = rs.getMetaData().getColumnCount();
					for (int i = 1; i <= numberOfColumns; i++) {
						rowData.append(rs.getObject(i).toString());
						if (i != numberOfColumns) {
							rowData.append(",");
						}

						if (columnNames.size() < numberOfColumns)
							columnNames.add(rs.getMetaData().getColumnName(i));
					}
					list.add(rowData.toString());
				}

				queryDetails.setColumnNames(columnNames);
				queryDetails.setData(list);
				return queryDetails;
			}
		});
	}

}
