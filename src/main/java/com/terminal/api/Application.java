package com.terminal.api;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.terminal.api.model.RolResponse;
import com.terminal.api.repository.RolRepository;
import net.ucanaccess.converters.FunctionsAggregate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


//@EnableJpaRepositories("com.terminal.api.repository")
@ComponentScan(basePackages = "com.terminal.api")
@EntityScan("com.terminal.api.entity") 
@SpringBootApplication(scanBasePackages = {"com.terminal.api.service","com.terminal.api.repository","com.terminal.api"})

//@EnableJdbcRepositories(basePackageClasses = RolRepository.class)

/*@EnableAutoConfiguration(exclude = {
	       DataSourceAutoConfiguration.class,
	       DataSourceTransactionManagerAutoConfiguration.class,
	       HibernateJpaAutoConfiguration.class})*/
public class Application implements CommandLineRunner {

	@Autowired
	private JdbcTemplate template;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//template.update("INSERT INTO rol(rol, descripcion) VALUES ('Chennai', 'first')");
		
		List<RolResponse> emplist = template.query("SELECT rol, descripcion FROM rol", new RowMapper<RolResponse>() {

			@Override
			public RolResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new RolResponse(rs.getString("rol"), rs.getString("descripcion"));
			}
		});

		emplist.forEach(System.out::println);
		for (RolResponse rol : emplist) {
			System.out.println(""+rol.getRol());
		}
	}
}
