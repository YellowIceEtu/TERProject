<%@ include file="/WEB-INF/jsp/header.jsp"%>


<c:url var="view" value="/formationDetails" />
<c:url var="add" value="/correspondant/addAdress" />

<div>
    <%@ include file="/WEB-INF/jsp/nav.jsp"%>
</div>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="container">

                <h1> Liste des formations de la composante : </h1>
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
                        <td><c:out value="${formation.code}" /></td>
                        <td><c:out value="${formation.etatEdition}" /></td>
                        <td> <a href="${view}?id=${formation.id}"> <i class="fas fa-eye"></i></a></td>

                    </tr>
                    </c:forEach>

                </table>

                <table class="table">
                    <h1> Liste des adresses de la composante :  </h1>
                    <thead>
                    <tr>
                        <th scope="col">Ligne</th>
                        <th></th>
                        <th></th>
                        <th></th>
                    </tr>
                    </thead>

                    <tbody>
                    <c:forEach items="${composante.adresses}" var="adresse">
                        <tr>

                            <td><c:out value="${adresse.ligne}" /></td>

                            <td><a class="btn btn-outline-primary"
                                   href="/person/edit/${person.id}" role="submit">Modifier</a></td>
                            <td><a href="/person/remove/${person.id}"
                                   class="btn btn-outline-primary" type="submit">Supprimer</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>

                </table>

        <button class="ajouter-adresse-button"><a href="${add}">Ajouter une addresse</a></button>

</div>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>
