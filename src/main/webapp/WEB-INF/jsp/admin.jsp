<%@ include file="/WEB-INF/jsp/header.jsp"%>


<c:url var="view" value="/formationDetails" />

<div>
    <%@ include file="/WEB-INF/jsp/nav.jsp"%>
</div>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container">

    <ul>
        <li>
    <table class="table">
        <tr>
        <th> <h1> Liste des composantes :  </h1> </th>
        </tr>
        <tr>

            <td>
            <c:forEach items="${composante}" var="composante">
       <h3> <c:out value="${composante.intitule}"/></h3>
            </c:forEach></td>
        </tr>


    </table>
        </li>
    </ul>

    <div class="top">
    <button class="ajouter-composante-button"><a href=#>Ajouter une composante</a></button>
    <button class="ajouter-formation-button"><a href=#>Ajouter une formation</a></button>
</div>

    <div class="bottom">
    <button class="gerer-utilisateur-button"><a href=#>Gérer les utilisateurs</a></button>
    <button class="exporter-données-button"><a href=#>Exporter les données</a></button>
</div>
</div>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>
