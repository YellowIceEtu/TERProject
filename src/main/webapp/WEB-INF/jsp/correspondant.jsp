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
                <h1> Liste des formations de la composante :  </h1>
                <tr>
                    <th> Composante :</th>
                </tr>
                <tr>
                    <td>
                        <c:forEach items="${composante}" var="composante">
                            <h3> <c:out value="${composante.intitule}"/></h3>
                        </c:forEach></td>
                </tr>


            </table>
            <table class="table">
                <h1> Liste des adresses de la composante :  </h1>
                <tr>


                </tr>


            </table>
        </li>
    </ul>




        <button class="exporter-données-button"><a href=#>Ajouter une addresse</a></button>

</div>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>
