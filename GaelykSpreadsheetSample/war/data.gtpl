<html><head/><body>
<span>counter:<%= request.getAttribute('counter') %></span>
<form>
<input type="button" value="Reload" onClick="window.location='/data.groovy'">
</form>
<img src='<%= request.getAttribute('appendix') %>'/>
</body>
