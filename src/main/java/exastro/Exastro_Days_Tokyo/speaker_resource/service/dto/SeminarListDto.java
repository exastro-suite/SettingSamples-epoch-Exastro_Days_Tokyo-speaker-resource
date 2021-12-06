package exastro.Exastro_Days_Tokyo.speaker_resource.service.dto;

import java.util.Date;

public class SeminarListDto extends SeminarDto{
	private int seminarId;
	private Date startDatetime;
	private int isDeleted;
	private int blockId;
	private int speakerId;
	private int eventId;
	
	public SeminarListDto(int seminarId) {
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
	public int getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
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

