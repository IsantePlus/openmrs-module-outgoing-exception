<%
    def artifactId = "outgoing-message-exceptions"
%>

<style>
    .label {
        width: 200px;
    }
</style>

<table>
    <% if (outgoingMessage != null) { %>
        <tr>
            <th class="label">${ ui.message(artifactId + ".details.id.label") }</th>
            <td>${ outgoingMessage.id }</td>
        </tr><tr>
            <th class="label">${ ui.message(artifactId + ".details.messageBody.label") }</th>
            <td><textarea style="width:100%" disabled>${ outgoingMessage.messageBody }</textarea></td>
        </tr><tr>
            <th class="label">${ ui.message(artifactId + ".details.timestamp.label") }</th>
            <td>${ outgoingMessage.timestamp }</td>
        </tr><tr>
            <th class="label">${ ui.message(artifactId + ".details.failureReason.label") }</th>
            <td>${ outgoingMessage.failureReason }</td>
        </tr><tr>
            <th class="label">${ ui.message(artifactId + ".details.destination.label") }</th>
            <td>${ outgoingMessage.destination }</td>
        </tr><tr>
            <th class="label">${ ui.message(artifactId + ".details.type.label") }</th>
            <td>${ outgoingMessage.type }</td>
        </tr><tr>
            <th class="label">${ ui.message(artifactId + ".details.failure.label") }</th>
            <td>${ outgoingMessage.failure }</td>
        </tr><tr>
            <th class="label">${ ui.message(artifactId + ".details.owner.label") }</th>
            <td>${ outgoingMessage.owner }</td>
        </tr>
    <% } else { %>
        <tr>
            <th>${ ui.message(artifactId + '.details.messageNotFound') }</th>
        </tr>
    <% } %>
</table>