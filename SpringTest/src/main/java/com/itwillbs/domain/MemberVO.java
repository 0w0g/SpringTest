package com.itwillbs.domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class MemberVO {
	private String userid;
	private String userpw;
	private String useremail;
	private String username;
	private Timestamp regdate;
	private Timestamp updatedate;
}
