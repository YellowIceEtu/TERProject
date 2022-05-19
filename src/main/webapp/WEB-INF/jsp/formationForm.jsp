<%@ include file="/WEB-INF/jsp/header.jsp"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="container">
    <h1>Edit Formation</h1>

    <form:form method="POST" modelAttribute="formation">

        <form:errors path="*" cssClass="alert alert-danger" element="div" />

        <div class="form-group">
            <label for="codeFormation">Code Formation:</label>
            <form:input class="form-control" path="codeFormation" />
            <form:errors path="codeFormation" cssClass="alert alert-warning" element="div" />
        </div>
        <div class="form-group">
            <label for="etatEdition">Etat Edition:</label>
            <form:textarea class="form-control" path="etatEdition" rows="4" />
            <form:errors path="etatEdition" cssClass="alert alert-warning"
                         element="div" />
        </div>
        <div class="form-group">
            <label for="intitule">Intitule :</label>
            <form:input path="intitule" class="form-control" />
            <form:errors path="intitule" cssClass="alert alert-warning"
                         element="div" />
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-info">Submit</button>
        </div>
    </form:form>
</div>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>
