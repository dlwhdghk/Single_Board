package hwa.jong.lee.dto;

public class CommentVO {
	int comment_number;
	int comment_board_number;
	String comment_writer;
	String comment_context;
	public int getComment_number() {
		return comment_number;
	}
	public void setComment_number(int comment_number) {
		this.comment_number = comment_number;
	}
	public int getComment_board_number() {
		return comment_board_number;
	}
	public void setComment_board_number(int comment_board_number) {
		this.comment_board_number = comment_board_number;
	}
	public String getComment_writer() {
		return comment_writer;
	}
	public void setComment_writer(String comment_writer) {
		this.comment_writer = comment_writer;
	}
	public String getComment_context() {
		return comment_context;
	}
	public void setComment_context(String comment_context) {
		this.comment_context = comment_context;
	}
	
}
