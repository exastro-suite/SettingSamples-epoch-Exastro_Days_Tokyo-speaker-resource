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
import exastro.Exastro_Days_Tokyo.speaker_resource.service.dto.SpeakerDto;

@Service
public class SpeakerResourceService extends BaseSpeakerService implements SpeakerService {

	public SpeakerResourceService() {
	}
	
	public SpeakerDto getSpeakerDetail(int speaker_id) {
		
		SpeakerDto speakerInfo =null;
		try {
			//登壇者ID に紐づく登壇者情報を取得
			Speaker s = speaker_repo.findBySpeakerIdIs(speaker_id);
			speakerInfo = new SpeakerDto(s.getSpeakerId(), s.getSpeakerName(), 
					s.getSpeakerProfile(), s.isDeleteFlag());
		}
		catch(Exception e) {
			throw e;
		}
		return speakerInfo;
	}
	
	public List<String> getEventSpeakerList(List<Integer> speakerIdList){
		List<String> speakerList = null;
		try {
			//イベントに紐づく登壇者一覧を取得
			speakerList = speaker_repo.findByDeleteFlagFalseAndSpeakerIdIn(speakerIdList)
				.stream()
				.map(s -> s.getSpeakerName())
				.distinct()
				.collect(Collectors.toList());
		}
		catch(Exception e) {
			throw e;
		}
		return speakerList;
	}
}
