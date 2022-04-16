package dao;

public class NoticeQuery {
	public static final String SELECT_NOTICE_LIST5;
	public static final String SELECT_NOTICE_LAST_PAGE;
	public static final String SELECT_NOTICE_LIST;
	public static final String SELECT_NOTICE_ONE;
	static {
		SELECT_NOTICE_LIST = "SELECT notice_no noticeNo ,notice_content noticeContent,notice_title noticeTitle, create_date createDate,update_date updateDate FROM notice ORDER BY createDate DESC LIMIT ?, ?";
		//
		SELECT_NOTICE_LIST5 = "SELECT notice_no noticeNo ,notice_title noticeTitle, create_date createDate FROM notice ORDER BY createDate DESC LIMIT 0, 5";
		
		SELECT_NOTICE_LAST_PAGE = "SELECT count(*) FROM notice";
		
		SELECT_NOTICE_ONE = "SELECT notice_no noticeNo ,notice_content noticeContent,notice_title noticeTitle, create_date createDate,update_date updateDate FROM notice WHERE notice_no = ? ";
	}
}
