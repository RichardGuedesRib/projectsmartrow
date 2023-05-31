package br.edu.fateccotia.projectsmartrow.util;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import br.edu.fateccotia.projectsmartrow.model.Bebidas;
import br.edu.fateccotia.projectsmartrow.model.Cardapio;
import br.edu.fateccotia.projectsmartrow.model.Endereco;
import br.edu.fateccotia.projectsmartrow.model.Estabelecimento;
import br.edu.fateccotia.projectsmartrow.model.Pratos;

public class JsonInObject {

	public static Estabelecimento stringToEstabelecimento(String stringSb) {
		JSONObject obj = new JSONObject(stringSb);
		Estabelecimento estabelecimento = new Estabelecimento();

		estabelecimento.setIDEstabelecimento(obj.getInt("idestabelecimento"));
		estabelecimento.setNome(obj.getString("nome"));
		estabelecimento.setCnpj(obj.getString("cnpj"));
		estabelecimento.setTelefone(obj.getString("telefone"));
		estabelecimento.setTelefone2(obj.getString("telefone2"));
		estabelecimento.setEmail(obj.getString("email"));
		estabelecimento.setSenha(obj.getString("senha"));
		estabelecimento.setEmailIsValid(obj.getBoolean("emailIsValid"));
		estabelecimento.setHorarioFuncionamento(obj.getString("horarioFuncionamento"));
		estabelecimento.setImagemEstabelecimento(null);
		estabelecimento.setFaturamento(null);

		System.out.println("INSTANCIOU ESTABELECIMENTO<<<<<<<<<<<<<<<<<<<<<<<");
		System.out.println("STRING RECEBIDA = " + stringSb);
		if (obj.has("cardapio") && !obj.isNull("cardapio")) {
			JSONObject objCardapio = obj.getJSONObject("cardapio");
			Cardapio cardapio = new Cardapio();
			List<Pratos> listPratos = new ArrayList<>();

			JSONArray pratosArray = objCardapio.getJSONArray("pratos");
			System.out.println("INICIOU PRATO<<<<<<<<<<<<<<<<<<<<<<<");
			if (pratosArray.isNull(0) != true) {
				System.out.println("INICIOU IFPRATOPRATO<<<<<<<<<<<<<<<<<<<<<<<");
				for (int i = 0; i < pratosArray.length(); i++) {
					JSONObject pratojson = pratosArray.getJSONObject(i);
					Pratos newPrato = new Pratos();
					newPrato.setIDPrato(pratojson.getInt("idprato"));
					newPrato.setNome(pratojson.getString("nome"));
					newPrato.setTipoPrato(pratojson.getString("tipoPrato"));
					newPrato.setIngredientes(pratojson.getString("ingredientes"));
					newPrato.setValor(pratojson.getDouble("valor"));
					newPrato.setImagem(pratojson.getString("imagem"));

					listPratos.add(newPrato);
				}
				cardapio.setListPratos(listPratos);
			} else {
				cardapio.setListPratos(null);
			}

			JSONArray listobjBebidas = objCardapio.getJSONArray("bebidas");
			System.out.println("INICIOU BEBIDA<<<<<<<<<<<<<<<<<<<<<<<");
			if (listobjBebidas.isNull(0) != true) {
				System.out.println("INICIOU LOOPBEBIDA<<<<<<<<<<<<<<<<<<<<<<<");
				List<Bebidas> listBebidas = new ArrayList<>();
				for (int i = 0; i < listobjBebidas.length(); i++) {
					JSONObject objBebidas = listobjBebidas.getJSONObject(i);
					Bebidas bebida = new Bebidas();
					bebida.setIDBebida(objBebidas.getInt("idbebida"));
					bebida.setNome(objBebidas.getString("nome"));
					bebida.setTipoBebida(objBebidas.getString("tipoBebida"));
					bebida.setValor(objBebidas.getDouble("valor"));
					bebida.setImagem(objBebidas.getString("imagem"));

					listBebidas.add(bebida);

				}
				cardapio.setListBebidas(listBebidas);
			} else {
				cardapio.setListBebidas(null);
			}
			estabelecimento.setCardapio(cardapio);
		} else {
			estabelecimento.setCardapio(null);
		}
		
		if(obj.has("endereco") && !obj.isNull("endereco") && !obj.getJSONObject("endereco").isEmpty()) {
			System.out.println("ENTROU NO ENDERECO <<<<<<<<<<<<<<<<<<<<<<<<");
			JSONObject end = obj.getJSONObject("endereco");
			
			Endereco endereco = new Endereco();
			endereco.setCep(end.getString("cep"));
			endereco.setLocalidade(end.getString("localidade"));
			endereco.setLogradouro(end.getString("logradouro"));	//Extrai do objeto Json e converte nos Sets dentro do Objeto Endereço
			endereco.setPais("Brasil");
			endereco.setUf(end.getString("uf"));
			endereco.setBairro(end.getString("bairro"));
			endereco.setId(end.getInt("id"));
			endereco.setNumero(end.getString("numero"));
			endereco.setComplemento(end.getString("complemento"));
			endereco.setReferencia(end.getString("referencia"));
			
			estabelecimento.setEndereco(endereco);
			System.out.println("add  ENDERECO <<<<<<<<<<<<<<<<<<<<<<<<");
			
		}
		System.out.println("FINALIZOU <<<<<<<<<<<<<<<<<<<<<<<<");

		return estabelecimento;
	}

}
