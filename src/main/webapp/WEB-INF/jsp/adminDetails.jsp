<%@ include file="/WEB-INF/jsp/header.jsp"%>
<div>
    <%@ include file="/WEB-INF/jsp/nav.jsp"%>
</div>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="container">
    <div class="d-flex justify-content-between p-4">
        <h1> Déscriptif de l'administrateur </h1>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Nom</th>
            <th scope="col">Pr�nom</th>
            <th scope="col">Administrateur </th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${utilisateurs.}" var="utilisateur">
            <tr>
                <td><c:out value="${utilisateur.nom}" /></td>
                <td><c:out value="${utilisateur.prenom}" /></td>
                <td><c:out value="${utilisateur.estAdmin}" /></td>
            </tr>

        </c:forEach>
        </tbody>
    </table>

</div>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>
