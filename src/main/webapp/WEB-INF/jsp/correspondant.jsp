<%@ include file="/WEB-INF/jsp/header.jsp"%>


<c:url var="view" value="/formationDetails" />
<c:url var="add" value="correspondant/addAdresse" />

<div>
    <%@ include file="/WEB-INF/jsp/nav.jsp"%>
</div>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container">

    <h1> Liste des formations de la composante : </h1>

    <ul>

            <li>
               </li>
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
                        <td><c:out value="${formation.code}" /></td>
                        <td><c:out value="${formation.etatEdition}" /></td>
                        <td> <a href="${view}?id=${formation.id}"> <i class="fas fa-eye"></i></a></td>

                    </tr>
                    </c:forEach>

                </table>

                <table class="table">
                    <h1> Liste des adresses de la composante :  </h1>


                            <c:out value="${composante.adresses}"/>

                </table>
            </li>


    </ul>




        <button class="ajouter-adresse-button"><a href="${add}">Ajouter une addresse</a></button>

</div>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>
