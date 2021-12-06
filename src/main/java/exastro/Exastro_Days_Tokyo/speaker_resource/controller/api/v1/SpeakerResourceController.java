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

package exastro.Exastro_Days_Tokyo.speaker_resource.controller.api.v1;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import exastro.Exastro_Days_Tokyo.speaker_resource.controller.api.v1.form.SpeakerForm;
import exastro.Exastro_Days_Tokyo.speaker_resource.service.dto.SpeakerDto;

@RestController
@RequestMapping("/api/v1/speaker")
public class SpeakerResourceController extends BaseSpeakerController {
	
	public SpeakerResourceController() {
		
	}
	
	@GetMapping("/{speaker_id}")
	public SpeakerForm SpeakerDetail(@PathVariable(value = "speaker_id") @Validated int speaker_id) {
		
		//登壇者マスターから取得
		SpeakerForm SpeakerDetail = null;
		try {
			SpeakerDto e = service.getSpeakerDetail(speaker_id);
			SpeakerDetail = new SpeakerForm(e.getSpeakerId(), e.getSpeakerName(),
					 e.getSpeakerProfile(), e.getIsDeleted());
		
		}
		catch(Exception e) {
			throw e;
		}
		
		return SpeakerDetail;
	}

}
