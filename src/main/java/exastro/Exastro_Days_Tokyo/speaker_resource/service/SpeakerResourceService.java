/*   Copyright 2021 NEC Corporation
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package exastro.Exastro_Days_Tokyo.speaker_resource.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import exastro.Exastro_Days_Tokyo.speaker_resource.repository.entity.Speaker;
import exastro.Exastro_Days_Tokyo.speaker_resource.service.dto.SpeakerDetailDto;
import exastro.Exastro_Days_Tokyo.speaker_resource.service.dto.SpeakerDto;

@Service
public class SpeakerResourceService extends BaseSpeakerService implements SpeakerService {
	
	public SpeakerResourceService() {
	}
	
	public  List<SpeakerDto> getSpeakerList(){
		List<SpeakerDto> speakerList = null;
		try {
			//登壇者一覧から登壇者一覧を取得(admin機能)
			speakerList = repository.findByDeleteFlagFalse()
					.stream()
					.map(s -> new SpeakerDto(s.getSpeakerId(), s.getSpeakerName()))
					.collect(Collectors.toList());
		}
		catch(Exception e) {
			throw e;
		}
		
		return speakerList;
	}
	
	public List<SpeakerDto> getEventSpeakerList(List<Integer> speakerIdList){
		
		List<SpeakerDto> speakerList = null;
		
		try {
			//イベントに紐づく登壇者一覧を取得
			speakerList = repository.findByDeleteFlagFalseAndSpeakerIdIn(speakerIdList)
				.stream()
				.map(s -> new SpeakerDto(s.getSpeakerId(), s.getSpeakerName()))
				.distinct()
				.collect(Collectors.toList());
		}
		catch(Exception e) {
			throw e;
		}
		return speakerList;
	}
	
	public String registerSpeaker(SpeakerDetailDto sv) {
		
		Speaker speaker = null;
		String resultStr = null;
		try {
			speaker = new Speaker(sv.getSpeakerName(), sv.getSpeakerProfile());
			Speaker result = repository.save(speaker);
			
			resultStr = "{\"result\":\"ok\", \"speaker_id\":" + result.getSpeakerId() + "}";
		}
		catch(Exception e) {
			throw e;
		}
		
		return resultStr;
	}
	
	public String updateSpeaker(SpeakerDetailDto sv) {
		
		String resultStr = null;
		try {
			Speaker speakerTarget = repository.findBySpeakerIdIsAndDeleteFlagFalse(sv.getSpeakerId());
			speakerTarget.setSpeakerId(sv.getSpeakerId());
			speakerTarget.setSpeakerName(sv.getSpeakerName());
			speakerTarget.setSpeakerProfile(sv.getSpeakerProfile());
//			speakerTarget.setDeleteFlag(sv.isDeleteFlag());
			Speaker result = repository.save(speakerTarget);
			
			resultStr = "{\"result\":\"ok\"}";
		}
		catch(Exception e) {
			throw e;
		}
		
		return resultStr;
	}
	
	public String deleteSpeaker(int speakerId) {
		
		String resultStr = null;
		try {
			Speaker speakerTarget = repository.findBySpeakerIdIsAndDeleteFlagFalse(speakerId);
			
			speakerTarget.setDeleteFlag(true);
			Speaker result = repository.save(speakerTarget);
			
			resultStr = "{\"result\":\"ok\"}";
		}
		catch(Exception e) {
			throw e;
		}
		
		return resultStr;
	}
}
