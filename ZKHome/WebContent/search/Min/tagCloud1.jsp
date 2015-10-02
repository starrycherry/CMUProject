<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, org.zkoss.zk.ui.Sessions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>jQCloud Example</title>
    <link rel="stylesheet" type="text/css" href="jqcloud.css" />
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.4/jquery.js"></script>
    <script type="text/javascript" src="jqcloud-1.0.4.js"></script>
    <script type="text/javascript">
    	<%
			List list = (List) Sessions.getCurrent().getAttribute("searchList");
			pageContext.setAttribute("list", list); 
		%>
		function Word(text, weight) {
			this.text = text;
			this.weight = weight;
		}
		var list = "${list}";
		var array = list.split(", ", 10);
		array[0] = array[0].substring(1);
		array[array.length - 1] = array[array.length - 1].substring(0, array[array.length - 1].length - 1);
      	var word_list = new Array();
      	for(var i = 0; i < array.length; i++) {
      		word_list[i] = new Word(array[i], parseInt(13 * Math.random() + 3));
      	}
      	$(function() {
        	$("#my_favorite_latin_words").jQCloud(word_list);
      	});
    </script>
  </head>
  <body>
    <div id="my_favorite_latin_words" style="width: 580px; height: 220px; border: none"></div>
  </body>
</html>