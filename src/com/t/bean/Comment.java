package com.t.bean;

import java.util.Date;

public class Comment {
	private int id;
	private String reply;//标题
	private String content;//内容
	private String nick_name;//作者
	private Date create_time;//评论时间
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Comment(int id, String reply, String content, String nick_name, Date create_time) {
		super();
		this.id = id;
		this.reply = reply;
		this.content = content;
		this.nick_name = nick_name;
		this.create_time = create_time;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getNick_name() {
		return nick_name;
	}
	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	@Override
	public String toString() {
		return "Comment [id=" + id + ", reply=" + reply + ", content=" + content + ", nick_name=" + nick_name
				+ ", create_time=" + create_time + "]";
	}
	
	
	
	
}
