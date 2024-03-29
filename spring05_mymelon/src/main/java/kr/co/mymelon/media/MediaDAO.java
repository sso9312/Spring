package kr.co.mymelon.media;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.co.mymelon.mediagroup.MediagroupDTO;

@Repository
public class MediaDAO {

	@Autowired
	private JdbcTemplate jt;

	StringBuilder sql = null;

	public MediaDAO() {
		System.out.println("------MediaDAO()객체 생성됨");
	}// end

	public List<MediaDTO> list(int mediagroupno) {
		List<MediaDTO> list = null;
		try {
			sql = new StringBuilder();
			sql.append(" SELECT mediano, title, rdate, poster, filename, filesize, mview, mediagroupno ");
			sql.append(" FROM media ");
			sql.append(" WHERE mview='Y' AND mediagroupno =  " + mediagroupno);
			sql.append(" ORDER BY mediano DESC ");

			RowMapper<MediaDTO> rowMapper = new RowMapper<MediaDTO>() {
				@Override
				public MediaDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
					MediaDTO dto = new MediaDTO();
					dto.setMediano(rs.getInt("mediano"));
					dto.setTitle(rs.getString("title"));
					dto.setRdate(rs.getString("rdate"));
					dto.setPoster(rs.getString("poster"));
					dto.setFilename(rs.getString("filename"));
					dto.setFilesize(rs.getLong("filesize"));
					dto.setMview(rs.getString("mview"));
					dto.setMediagroupno(rs.getInt("mediagroupno"));
					return dto;
				}// mapRow() end
			};// rowMapper end

			list = jt.query(sql.toString(), rowMapper);

		} catch (Exception e) {
			System.out.println("media목록 실패:" + e);
		} // end
		return list;
	}// list() end

	public int create(MediaDTO dto) {
		int cnt = 0;
		try {
			sql = new StringBuilder();

			sql.append(" INSERT INTO media(mediano, title, poster, filename, filesize, mediagroupno, rdate ) ");
			sql.append(" VALUES (media_seq.nextval, ?, ?, ?, ?, ?, sysdate) ");

			cnt = jt.update(sql.toString(), dto.getTitle(), dto.getPoster(), dto.getFilename(), dto.getFilesize(),
					dto.getMediagroupno());

		} catch (Exception e) {
			System.out.println("음원등록실패" + e);
		} // end
		return cnt;
	}// create() end

	public MediaDTO read(int mediano) {
		MediaDTO dto = null;
		try {
			sql = new StringBuilder();
			sql.append(" SELECT mediano, title, rdate, poster, filename, filesize, mview, mediagroupno ");
			sql.append(" FROM media ");
			sql.append(" WHERE mediano =  " + mediano);
			
			RowMapper<MediaDTO> rowMapper = new RowMapper<MediaDTO>() {
				@Override
				public MediaDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
					MediaDTO dto = new MediaDTO();
					dto.setMediano(rs.getInt("mediano"));
					dto.setTitle(rs.getString("title"));
					dto.setRdate(rs.getString("rdate"));
					dto.setPoster(rs.getString("poster"));
					dto.setFilename(rs.getString("filename"));
					dto.setFilesize(rs.getLong("filesize"));
					dto.setMview(rs.getString("mview"));
					dto.setMediagroupno(rs.getInt("mediagroupno"));
					return dto;
				}// mapRow() end
			};// rowMapper end
			dto = jt.queryForObject(sql.toString(), rowMapper);
			
		} catch (Exception e) {
			System.out.println("상세보기실패" + e);
		} // end
		return dto;
	}// read() end

	public int update(MediaDTO dto) {
		int cnt = 0;
		try {
			sql = new StringBuilder();
			sql.append(" UPDATE media ");
			sql.append(" SET title=?, poster=?, filename=?, filesize=? ");
			sql.append(" WHERE mediano=? ");
			cnt = jt.update(sql.toString(), dto.getTitle(), dto.getPoster(), dto.getFilename(), dto.getFilesize(), dto.getMediano());
		}catch(Exception e) {
			System.out.println("수정실패"+e);
		}//end
		return cnt;
	}//update end
	
	public int delete(int mediano) {
		int cnt = 0;
		try {
			sql = new StringBuilder();
			sql.append(" DELETE FROM media ");
			sql.append(" WHERE mediano=? ");
			cnt = jt.update(sql.toString(), mediano);
		}catch(Exception e) {
			System.out.println("삭제실패"+e);
		}//end
		return cnt;
	}//delete end
}// class end
