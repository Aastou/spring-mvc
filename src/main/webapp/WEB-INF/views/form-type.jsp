<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<form action="${pageContext.request.contextPath}/type" method="post">
    <input type="hidden" name="id" value="${type.id}">
    <label for="libelle">Libelle</label>
    <input type="text" id="libelle" name="libelle" value="${type.libelle}" />
    <button type="submit">Enregistrer</button>
</form>