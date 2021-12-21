package exastro.Exastro_Days_Tokyo.speaker_resource.repository.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
/**
 * The persistent class for the events database table.
 * 
 */
@Entity
@Table(name="seminars")
public class SeminarList{

	@Id
	@Column(name="seminar_id")
	private int seminarId;

	@Column(name="start_datetime")
	private Date startDatetime;

	@Column(name="delete_flag")
	private boolean deleteFlag;

	@Column(name="block_id")
	private int blockId;

	@Column(name="speaker_id")
	private int speakerId;

	@Column(name="event_id")
	private int eventId;
	
	public SeminarList() {	
	}
	
	
	public SeminarList(int seminarId) {
		this.seminarId = seminarId;
	}
	public int getSeminarId() {
		return seminarId;
	}
	public void setSeminarId(int seminarId) {
		this.seminarId = seminarId;
	}
	public Date getStartDatetime() {
		return startDatetime;
	}
	public void setStartDatetime(Date startDatetime) {
		this.startDatetime = startDatetime;
	}
	public boolean isDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public int getBlockId() {
		return blockId;
	}
	public void setBlockId(int blockId) {
		this.blockId = blockId;
	}
	public int getSpeakerId() {
		return speakerId;
	}
	public void setSpeakerId(int speakerId) {
		this.speakerId = speakerId;
	}
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
}

