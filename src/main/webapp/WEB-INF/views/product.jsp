<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<a href="${pageContext.request.contextPath}/product/new">Ajouter un produit</a>

<table>
  <tr>
    <th>ID</th>
    <th>Libelle</th>
    <th>Prix</th>
    <th>Type</th>
    <th>Actions</th>
  </tr>
  <c:forEach var="product" items="${products}">
    <tr>
      <td>${product.id}</td>
      <td>${product.libelle}</td>
      <td>${product.prix}</td>
      <td>${product.type.libelle}</td>
      <td>
        <a href="${pageContext.request.contextPath}/product/edit/${product.id}">Modifier</a>
        <a href="${pageContext.request.contextPath}/product/delete/${product.id}">Supprimer</a>
      </td>
    </tr>
  </c:forEach>
</table>