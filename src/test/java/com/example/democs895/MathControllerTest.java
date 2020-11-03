package com.example.democs895;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class MathControllerTest {

	@Autowired
	private MockMvc mvc;

	@Test
	public void getHello() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.TEXT_HTML))
				.andExpect(status().isOk());
	}

	@Test
	public void getAddition() throws Exception {

		mvc.perform(MockMvcRequestBuilders.get("/sum?x=5&y=7").accept(MediaType.TEXT_HTML))
				.andExpect(status().isOk())
				.andExpect(model().attributeExists("func"))
				.andExpect(model().attributeExists("x"))
				.andExpect(model().attributeExists("y"))
				.andExpect(model().attributeExists("answer"))
				.andExpect(model().attribute("func","Addition"))
				.andExpect(model().attribute("x","5"))
				.andExpect(model().attribute("y","7"))
				.andExpect(model().attribute("answer","12"));
	}

	@Test
	public void getMultiplication() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/mul?x=30&y=2").accept(MediaType.TEXT_HTML))
				.andExpect(status().isOk())
				.andExpect(model().attribute("func","Multiplication"))
				.andExpect(model().attribute("answer","60"));
	}

	@Test
	public void getSubtraction() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/sub?x=8&y=2").accept(MediaType.TEXT_HTML))
				.andExpect(status().isOk())
				.andExpect(model().attribute("func","Subtraction"))
				.andExpect(model().attribute("answer","6"));
	}

	@Test
	public void getinvalidAddition() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/sub?x=967").accept(MediaType.TEXT_HTML))
				.andExpect(status().isBadRequest());
	}

	@Test
	public void getinvalidAdditionWithStr() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/sub?x=you").accept(MediaType.TEXT_HTML))
				.andExpect(status().isBadRequest());
	}

	@Test
	public void getinvalidAdditionWithStrAndBothValues() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/sub?x=you&y=234").accept(MediaType.TEXT_HTML))
				.andExpect(status().isBadRequest());
	}


}





/*
package com.example.democs895;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MathControllerTest {

	@Autowired
	private MockMvc mvc;

	@Test
	public void getHello() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.TEXT_HTML))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("<!DOCTYPE html>\n<html lang=\"en\">\n    <head>\n        <title>Hello Thymeleaf!</title>\n        <meta charset=\"UTF-8\"/>\n        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>\n        <link rel=\"stylesheet\" href=\"/resources/css/styles.css\" type=\"text/css\"/>\n    </head>\n    <body>\n        <p >Hello, Gavindya!</p>\n    </body>\n</html>\n")));
	}

	@Test
	public void getAddition() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/sum?x=5&y=7").accept(MediaType.TEXT_HTML))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("<!DOCTYPE html>\n<html lang=\"en\">\n    <head>\n        <title>sumpage</title>\n        <meta charset=\"UTF-8\"/>\n        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>\n        <link rel=\"stylesheet\" href=\"/resources/css/styles.css\" type=\"text/css\"/>\n    </head>\n    <body>\n        <p >Addition of 5 and 7 is 12</p>\n    </body>\n</html>\n")));
	}

	@Test
	public void getMultiplication() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/mul?x=30&y=2").accept(MediaType.TEXT_HTML))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("<!DOCTYPE html>\n<html lang=\"en\">\n    <head>\n        <title>sumpage</title>\n        <meta charset=\"UTF-8\"/>\n        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>\n        <link rel=\"stylesheet\" href=\"/resources/css/styles.css\" type=\"text/css\"/>\n    </head>\n    <body>\n        <p >Multiplication of 30 and 2 is 60</p>\n    </body>\n</html>\n")));
	}

	@Test
	public void getSubtraction() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/sub?x=8&y=2").accept(MediaType.TEXT_HTML))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("<!DOCTYPE html>\n<html lang=\"en\">\n    <head>\n        <title>sumpage</title>\n        <meta charset=\"UTF-8\"/>\n        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>\n        <link rel=\"stylesheet\" href=\"/resources/css/styles.css\" type=\"text/css\"/>\n    </head>\n    <body>\n        <p >Subtraction of 8 and 2 is 6</p>\n    </body>\n</html>\n")));
	}

	@Test
	public void getinvalidAddition() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/sub?x=967").accept(MediaType.TEXT_HTML))
				.andExpect(status().isBadRequest());
	}

	@Test
	public void getinvalidAdditionWithStr() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/sub?x=you").accept(MediaType.TEXT_HTML))
				.andExpect(status().isBadRequest());
	}

	@Test
	public void getinvalidAdditionWithStrAndBothValues() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/sub?x=you&y=234").accept(MediaType.TEXT_HTML))
				.andExpect(status().isBadRequest());
	}
}

*/