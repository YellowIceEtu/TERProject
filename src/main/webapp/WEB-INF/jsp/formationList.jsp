<%@ include file="/WEB-INF/jsp/header.jsp"%>


<c:url var="view" value="/formationDetails" />

<div>
    <%@ include file="/WEB-INF/jsp/nav.jsp"%>
</div>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container">
    <h1>Formations  </h1>

    <ul>
        <c:forEach items="${composante}" var="composante">
            <li><h3>Composante : <c:out value="${composante.intitule}"/></h3></li>
            <li>
                <table class="table">
                    <tr>
                        <th> Intitule :</th>
                        <th>codeFormation :</th>
                        <th>etatEdition :</th>
                        <th> Profil : </th>
                    </tr>
                    <tr>
                        <c:forEach items="${composante.formations}" var="formation">
                        <td><c:out value="${formation.intitule}" /></td>
                        <td><c:out value="${formation.codeFormation}" /></td>
                        <td><c:out value="${formation.etatEdition}" /></td>
                        <td> <a href="${view}?id=${formation.id}"> <i class="fas fa-eye"></i></a></td>

                    </tr>
                    </c:forEach>

                </table>
            </li>
        </c:forEach>

    </ul>
</div>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>
