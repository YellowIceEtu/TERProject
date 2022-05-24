<%@ include file="/WEB-INF/jsp/header.jsp"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="container">
    <h1>Ajout d'une adresse</h1>

    <form:form action="addAdresse" method="POST" modelAttribute="adresse" >

        <form:errors path="*" cssClass="alert alert-danger" element="div" />



        <div class="form-group">
            <label for="adresse">Adresse :</label>
            <form:input path="adresse" type="text"  class="form-control" id="adresse" name="adresse" />
            <form:errors path="adresse" cssClass="alert alert-warning"
                         element="div" />
        </div>

        <div class="form-group">
            <button type="submit" class="btn btn-info">Submit</button>
        </div>
    </form:form>
</div>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>
