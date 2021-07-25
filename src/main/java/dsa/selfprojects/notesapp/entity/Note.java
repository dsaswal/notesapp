package dsa.selfprojects.notesapp.entity;

import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "note")
public class Note {

	@Id
	@Column(name = "NOTE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "NOTE")
	private String note;

	@Column(name = "CRTD_BY")
	private long createdBy;
	
	@Column(name = "CTGRY")
	private long ctgry;
	
	@Column(name = "CRTD_DT")
	private OffsetDateTime createdDate;
	
	@Column(name = "MOD_DT")
	private OffsetDateTime modifiedDate;
	
	@Column(name = "POINTS")
	private long points;

	@Column(name = "NXT_REVIEW_DAYS")
	private int nxtReviewDays;

	@Column(name = "NXT_REVIEW_DT")
	private OffsetDateTime nxtReviewDt;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}

	public long getCtgry() {
		return ctgry;
	}

	public void setCtgry(long topic) {
		this.ctgry = topic;
	}

	public OffsetDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(OffsetDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public OffsetDateTime getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(OffsetDateTime modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public long getPoints() {
		return points;
	}

	public void setPoints(long points) {
		this.points = points;
	}

	public int getNxtReviewDays() {
		return nxtReviewDays;
	}

	public void setNxtReviewDays(int nxtReviewDays) {
		this.nxtReviewDays = nxtReviewDays;
	}

	public OffsetDateTime getNxtReviewDt() {
		return nxtReviewDt;
	}

	public void setNxtReviewDt(OffsetDateTime nxtReviewDt) {
		this.nxtReviewDt = nxtReviewDt;
	}

	@Override
	public String toString() {
		return "Note [id=" + id + ", note=" + note + ", createdBy=" + createdBy + ", ctgry=" + ctgry
				+ ", createdDate=" + createdDate + ", modifiedDate=" + modifiedDate + ", points=" + points
				+ ", nxtReviewDays=" + nxtReviewDays + ", nxtReviewDt=" + nxtReviewDt + "]";
	}

//	public Note(long id, String note, long createdBy, long ctgry, OffsetDateTime createdDate,
//			OffsetDateTime modifiedDate, long points, int nxtReviewDays, OffsetDateTime nxtReviewDt) {
	public Note(String note, int nxtReviewDays) {
		super();
//		this.id = id;
		this.note = note;
//		this.createdBy = createdBy;
//		this.topic_id = ctgry;
//		this.createdDate = createdDate;
//		this.modifiedDate = modifiedDate;
//		this.points = points;
		this.nxtReviewDays = nxtReviewDays;
//		this.nxtReviewDt = nxtReviewDt;
	}

	public Note() {
		super();
	}

}

