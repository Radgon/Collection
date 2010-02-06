<html>
 <head><title>A Simple GTPL</title></head>
  <body>
   <b><% print "Hello Gaelyk!".replace(" ", " from ") %></b>
   <p>
   <ol>
    <% def wrd = "Groovy"
       wrd.each{ letter ->
    %>
    <li><%= letter %></li>
    <% } %>
   </ol>
   </p>
  </body>
</html>