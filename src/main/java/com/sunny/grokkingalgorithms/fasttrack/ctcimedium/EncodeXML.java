package com.sunny.grokkingalgorithms.fasttrack.ctcimedium;

import org.w3c.dom.Attr;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Element{
  @Override
  public String toString() {
    return "Element{" +
        "name='" + name + '\'' +
        ", attributes=" + attributes +
        ", cdata='" + cdata + '\'' +
        ", elements=" + elements +
        '}';
  }

  String name;
  List<Attribute> attributes;
  String cdata;
  List<Element> elements;
}
class Attribute{
  String id;

  @Override
  public String toString() {
    return "Attribute{" +
        "id='" + id + '\'' +
        ", value='" + value + '\'' +
        '}';
  }

  String value;
}
/**
 * Created by sundas on 6/16/2018.
 */
public class EncodeXML {

  /*
  Given an xml , encode it tp reduce its verbosity.
   */


  /**
   *
   * @param root
   * @return
   */
  public static String encode(Element root){
    StringBuilder builder = new StringBuilder();
    Element current = root;
    Map<String,String> encoder = new HashMap<>();
    encoder.put("family","1");
    encoder.put("person","2");
    encoder.put("lastname","3");
    encoder.put("firstname","4");
    encoder.put("family","1");
    while(current != null){
      String name = current.name;
      encode(builder, encoder, name);
      List<Attribute> attributes = current.attributes;
      for(Attribute attribute : attributes){
        encode(builder,encoder,attribute.id);
        builder.append(attribute.value);
        builder.append(" ");
        builder.append("0");
        builder.append(" ");
      }
      if(current.cdata != null){
        builder.append(current.cdata);
        builder.append(" ");
        builder.append("0");
        builder.append(" ");
      }
      builder.append("0");
      builder.append(" ");
      if(current.elements != null){
        current = current.elements.get(0);
      }
      else{
        current = null;
      }
    }
    return builder.toString();
  }

  private static void encode(StringBuilder builder, Map<String, String> encoder, String name) {
    builder.append(encoder.get(name));
    builder.append(" ");
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    Element root = new Element();
    root.name = "family";
    Attribute lastName = new Attribute();
    lastName.id = "lastname";
    lastName.value = "das";
    List<Attribute> attributes = new ArrayList<>();
    attributes.add(lastName);
    root.attributes = attributes;
    Element person = new Element();
    person.name = "person";
    Attribute firstName = new Attribute();
    firstName.id = "firstname";
    firstName.value = "sunny";
    List<Attribute> attributes1 = new ArrayList<>();
    person.cdata = "hi there";
    attributes1.add(firstName);
    person.attributes = attributes1;
    List<Element> elements = new ArrayList<>();
    elements.add(person);
    root.elements = elements;
    System.out.println(encode(root));
  }

}
