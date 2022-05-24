<%@ page import="mybootapp.model.Formation" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="/WEB-INF/jsp/header.jsp"%>


<div>
    <%@ include file="/WEB-INF/jsp/nav.jsp"%>
</div>

<html>
<head>

</head>
<body>

    <div class="container">
        <h1>Ajout d'une formation</h1>

        <form:form action="saveFormationCreation" method="POST" modelAttribute="formation" >

            <form:errors path="*" cssClass="alert alert-danger" element="div" />

            <div class="form-group">
                <label for="CERTIFINFO">Code CERTIFINFO :</label>
                <form:input path="formation" class="form-control" name="CERTIFINFO" />
                <form:errors path="formation" cssClass="alert alert-warning"
                             element="div" />
            </div>
            <div class="form-group">
                <label for="code">code de la formation :</label>
                <form:input path="formation" type="text"  class="form-control"  name="code" />
                <form:errors path="formation" cssClass="alert alert-warning"
                             element="div" />
            </div>

            <div class="form-group">
                <label for="intitule">intitulé de la formation :</label>
                <form:input path="formation" type="text"  class="form-control"  name="intitule" />
                <form:errors path="formation" cssClass="alert alert-warning"
                             element="div" />
            </div>

            <div class="form-group">
                <button type="submit" class="btn btn-info">Submit</button>
            </div>
        </form:form>
    </div>
</body>
</html>
