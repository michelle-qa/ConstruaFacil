package apiTests;

import org.testng.annotations.Test;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.not;

public class Pet {

    //Padrão
    //Given = Dado
    //When = Quando
    //Then = Então

    //Funçao de Apoio
    public String lerJson(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }

    @Test
    public void incluirPet() throws IOException { //Creat - Post

        String jsonBody = lerJson("src/test/resources/data/pet.json");

        given()                                                 //Dado
                .contentType("application/json")                //Tipo do conteúdo
                // "text/xml" para web services sincronos - ex: Correios
                // "application/json" para web services assincronos - ex: iFood
                .log().all()                                    //Registrar tudo do envio
                .body(jsonBody)
        .when()                                                         //Quando
                .post("https://petstore.swagger/v2/pet.json");     //Comando + endpoint
        [
                ].then()                                                         // Então
                .log() .all()                                           //Registrar tudo da volta
                .statusCode(200)                                   //valida o Código de Estado
                .body("id", is(1000))                              //Valida id do animal
                .body("name", is("Pipoca"))                              //Valida o nome do animal
                .body("category.name", is("dog"))                        //Valida a categoria do animal
                .body("tags.name", not(contains("não vermifugado")))
                .body("tags.name", contains("vacinas em dia"))
        ;

   }


}
