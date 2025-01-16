package com.example.demo;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;

import lombok.extern.slf4j.Slf4j;

@Slf4j
//아작스 컨트롤로 ( jons 형식으로 바껴서 들어옴 )
@RestController
//@Controller
public class SampleController {
		
	//위에 @Controller 하고 여기에 리스폰스 바디 해서 보내도됨
	//이렇게쓰면 들어가는 문자형태 바꿀수있음 쓰진 않음 그냥 쓸수있따고
	@GetMapping(value="/getText", produces = "text/plain; charset=UTF-8")
	public @ResponseBody String getText() {	// String 뷰페이지 명 리턴하는거아님 결과 값임
		return "안녕하세요";
	}
	
	@GetMapping(value="/getTextEntity")
	public ResponseEntity<String> getTextEntity() {	// String 뷰페이지 명 리턴하는거아님 결과 값임
		String  str = "안녕하세요";
		return new ResponseEntity<>(str, HttpStatus.BAD_GATEWAY);
	}
	
	//@RestController 로 인해서 객체를 넘기면 json 형식으로 리턴값을 반환한다.
	//이건 데이터만 넘어가는거
	@GetMapping("/getSample")
	public SampleVO getSample() {
		return new SampleVO(100, "길동", "김", new Date());
	}
	
	//이건 데이터와 함께 상태값도 같이 넘겨 줄수있다
	@GetMapping("/getSampleEntity")
	public ResponseEntity<SampleVO> getSampleEntity() {
		SampleVO sample = new SampleVO(100, "길동", "김", new Date());
		//return new ResponseEntity<>(sample, HttpStatus.INTERNAL_SERVER_ERROR);
		return new ResponseEntity<>(sample, HttpStatus.BAD_REQUEST);
	}
	
	//여러객체를 하나로 묶어서 한번에 던짐
	//Map<String,Object> 맵 공식 이걸로 해 무조건
	//   객체명 ,  객체내용   으로 하면 되겠다
	@GetMapping("/getMap")
	public Map<String,Object> getMap(){
		Map<String,Object> map = new HashMap<>();
		map.put("sample", new SampleVO(100, "길동", "김", new Date()) );
		map.put("total", 20);
		map.put("success", true);
		return map;
	}
	
	//http://localhost:81/product/pingpinglee/1515
	//{}이자리엔 값이 들어온다로 하면됨 //여러개도 가능함
	// 패스베리어블드 방식 // 쿼리스트링 방식 아니고
	@GetMapping("/product/{cat}/{pid}")
	public String[] getPath(@PathVariable(name="cat") String cat, @PathVariable(name="pid") Integer prdid) {
		//return new String[] {cat, Integer.toString(prdid)};
		return new String[] {cat, ""+prdid};	//요렇게도 형변환 가능하다
	}
	
	
	//포스트라스 브메랑에서해야함
	//json 결과는 get으로는 못받음
	//일반 폼데이터 보내면 쿼리스트링 //JSON형식의 스트링이면 @RequestBody 이걸 꼭 적어줘야함
	//여러건이면 리스트로 감싸면 된다
	@PostMapping("/ticket")
	public List<Ticket> vonvert(@RequestBody List<Ticket> ticket) {
		log.info("★ticket : " + ticket);
		return ticket;
	}
	
	//여러가지 객체를 한번에 받는방법 VO 만들어야함!!! 
	@PostMapping("/comp")
	public CompVo com(@RequestBody CompVo comp) {
		//첫번째 티켓의 owner 출력
		log.info("owner" + comp.getList().get(0).getOwner());
		comp.getList().get(0).getOwner();
		return comp;
	}
	
	//이런식으로 VO 없이 맵으로 받아도 됨!!
	//근데 너무 불편함
//	@PostMapping("/compMap")
//	public Map<String, Object> compMap(@RequestBody Map<String, Object> map) {
//		//첫번째 티켓의 owner 출력
//		log.info("owner: "+ map.get("list"));
//		return map;
//	}
	
	//그래서 이런식으로 받으면 좋을꺼같음
	//근데 이거 몰라도 됨 그냥 vo로 받아 그게 최강이야
	@PostMapping("/compMap")
	public JsonNode compMap(@RequestBody JsonNode node) {
		log.info( "owner:" + node.get("list").get(0).get("owner").asText() );
		return node;
	}

	//영화정보
	@GetMapping("/movie")
	public String movie(@RequestParam(defaultValue = "20250115", required = false) String date) {
		RestTemplate restTemplate = new RestTemplate();
		//스트링에서 제공하는 다른서버 api 요청
		String uri = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=12664b24453335d2c3eca0fdc4b3b013&targetDt="+date;
		JsonNode node = restTemplate.getForObject(uri, JsonNode.class);
		
		//첫번째영화 이름 가져오기
		String moviename = node.get("boxOfficeResult").get("dailyBoxOfficeList").get(0).get("movieNm").asText();
		log.info("movie : " + moviename );
		return moviename;
	}
}
























