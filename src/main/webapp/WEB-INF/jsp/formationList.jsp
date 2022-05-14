<%@ include file="/WEB-INF/jsp/header.jsp"%>



<div>
    <%@ include file="/WEB-INF/jsp/nav.jsp"%>
</div>

<div class="container">
    <h1>Formations  </h1>
    <p><a href='logout/cas'>Logout</a></p>
    <table class="table table-hover">

        <tr>

            <td> Formations : </td>


            <td>codeFormation :</td>
            <td>etatEdition :</td>
            <td> dateMaj :</td>
            <td>dateCrea :</td>
            <td> Intitule :</td>
            <td>Objectif :</td>
        <tr>

            <td><c:out value="${}" /> </td>
            <td>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <c:out value="${}" />
            </td>
            <td>

                <c:out value="${}" />
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            </td>

            <td>

                <c:out value="${}" />
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            </td>
            <td>
                <c:out value="${}" />
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            </td>
            <td>
                <c:out value="${}" />

            </td>

            <td>
                <c:out value="${}" />

            </td>


        </tr>



    </table>





</div>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>
