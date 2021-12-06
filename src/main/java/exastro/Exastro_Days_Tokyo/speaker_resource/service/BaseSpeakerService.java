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

import org.springframework.beans.factory.annotation.Autowired;

import exastro.Exastro_Days_Tokyo.speaker_resource.repository.SpeakerRepository;
import exastro.Exastro_Days_Tokyo.speaker_resource.service.dto.SpeakerDto;

public abstract class BaseSpeakerService {
	
	@Autowired
	protected SpeakerRepository speaker_repo;
	
	public BaseSpeakerService() {
		
	}

	public  List<SpeakerDto> getSpeakerList(){
		List<SpeakerDto> speakerList = null;
		try {
			//登壇者一覧から登壇者一覧を取得
			speakerList = speaker_repo.findAll()
					.stream()
					.map(e -> new SpeakerDto(e.getSpeakerId(), e.getSpeakerName(), 
							e.getSpeakerProfile(), e.getIsDeleted()))
					.collect(Collectors.toList());
			
					}
		catch(Exception e) {
			throw e;
		}

		return speakerList;
	}

}
