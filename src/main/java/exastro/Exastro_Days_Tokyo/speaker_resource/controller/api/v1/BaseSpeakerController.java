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

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import exastro.Exastro_Days_Tokyo.speaker_resource.controller.api.v1.form.SpeakerForm;
import exastro.Exastro_Days_Tokyo.speaker_resource.service.SpeakerService;

//@RestController
//@RequestMapping("/api/v1/event")
public class BaseSpeakerController {
	
	@Autowired
	protected SpeakerService service;
	
	public BaseSpeakerController() {
		
	}
	
	@GetMapping("")
	public List<SpeakerForm> event() {
		
		List<SpeakerForm> speakerList = null;
		
		try {
			speakerList = service.getSpeakerList()
					.stream()
					.map(e -> new SpeakerForm(e.getSpeakerId(), e.getSpeakerName(), e.getSpeakerProfile(), e.getIsDeleted()))
					.collect(Collectors.toList());
		}
		catch(Exception e) {
			throw e;
		}
		
		return speakerList;
	}
}