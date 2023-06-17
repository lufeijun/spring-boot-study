package lufeijun.study.springbootdemo.model;


import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class User {
	private Long id;
	private String name;
	private Integer age;
	private String email;
	private String password;
	private String created;
	private String updated;
}
