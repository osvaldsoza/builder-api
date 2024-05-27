package br.com.crud;

import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.given;

@SpringBootTest
public class ClienteResourceTest {

    private static String baseURI;

    @BeforeAll
    public static void setup() {
        baseURI = "http://localhost:8080";
    }

    @Test
    public void testClientes() {
        given()
                .when()
                .get("/builders")
                .then()
                .statusCode(200);
    }

    @Test
    public void testSalvaCliente() throws JSONException {
        JSONObject empParams = new JSONObject();
        empParams.put("nome", "Fulano de Tal");
        empParams.put("dataNascimento", "24/07/1990");

        given()
                .contentType(ContentType.JSON)
                .body(empParams.toString())
                .post("/builders")
                .then()
                .assertThat().statusCode(201);
    }

    @Test
    public void testVerifcaClienteSalvoPeloNome() {
        given()
                .when()
                .param("nome", "Fulano de Tal")
                .get("/builders")
                .then()
                .body("$.size()", Matchers.greaterThan(0));
    }

    //TODO descomentar
    @Test
    public void testAtualizaCliente() throws JSONException {
        JSONObject empParams = new JSONObject();
        empParams.put("nome", "Fulano de Tal");
        empParams.put("dataNascimento", "24/07/1990");

        given()
                .contentType(ContentType.JSON)
                .body(empParams.toString())
                .put("/builders/")
                .then()
                .assertThat().statusCode(201);
    }
//
//    @Test
//    public void testExcluiClienteSalvo() {
//        given()
//                .when()
//                .delete("/builders/")
//                .then()
//                .statusCode(204);
//    }
}
