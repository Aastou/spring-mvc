<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<form action="${pageContext.request.contextPath}/product" method="post">
    <input type="hidden" name="id" value="${product.id}">
    <label for="libelle">Libelle</label>
    <input type="text" id="libelle" name="libelle" value="${product.libelle}" />
    <label for="prix">Prix</label>
    <input type="number" id="prix" name="prix" value="${product.prix}" />
    <label for="type">Type</label>
    <select id="type" name="type.id">
        <option value="">-- Choisir un type --</option>
        <c:forEach var="t" items="${types}">
            <option value="${t.id}" ${product.type.id == t.id ? 'selected' : ''}>${t.libelle}</option>
        </c:forEach>
    </select>
    <button type="submit">Enregistrer</button>
</form>