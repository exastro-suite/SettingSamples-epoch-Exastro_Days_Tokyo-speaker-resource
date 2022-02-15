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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import exastro.Exastro_Days_Tokyo.speaker_resource.service.SpeakerService;

@RestController
@RequestMapping("/api/v1/speaker")
public class SpeakerResourceController extends BaseSpeakerController{
	
	@Autowired
	protected SpeakerService service;
	
	public SpeakerResourceController() {
	}
	

//	@GetMapping("")
//	public List<SpeakerForm> speakerList(){
//
//		logger.debug("method called. [ " + Thread.currentThread().getStackTrace()[1].getMethodName() + " ]");
//		
//		List<SpeakerForm> speakerList = null;
//		
//		try {
//			speakerList = service.getSpeakerList()
//					.stream()
//					.map(s -> new SpeakerForm(s.getSpeakerId(), s.getSpeakerName()))
//					.collect(Collectors.toList());
//		}
//		catch(Exception e) {
//			logger.debug(e.getMessage(), e);
//			throw e;
//		}
//		
//		return speakerList;
//	}
	
	//登壇者IDListをもとに登壇者名を返す。
	@GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<String> speaker(@RequestParam(name = "speaker_id", required = false) List<Integer> speakerIdList) {
		logger.debug("method called. [ " + Thread.currentThread().getStackTrace()[1].getMethodName() + " ]");		
		
		List<String> speakerList = null;
		
		try {
			speakerList = service.getEventSpeakerList(speakerIdList);
		}
		catch(Exception e) {
			logger.debug(e.getMessage(), e);
			throw e;
		}
		return speakerList;
	}
}
