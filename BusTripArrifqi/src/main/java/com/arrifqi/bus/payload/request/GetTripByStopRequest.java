package com.arrifqi.bus.payload.request;

public class GetTripByStopRequest {
	private Long sourceStopid;
	
	private Long destStopId;
	

	public GetTripByStopRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GetTripByStopRequest(Long sourceStopid, Long destStopId) {
		super();
		this.sourceStopid = sourceStopid;
		this.destStopId = destStopId;
	}
	
	public Long getSourceStopid() {
		return sourceStopid;
	}

	public void setSourceStopid(Long sourceStopid) {
		this.sourceStopid = sourceStopid;
	}

	public Long getDestStopId() {
		return destStopId;
	}

	public void setDestStopId(Long destStopId) {
		this.destStopId = destStopId;
	}
}
