declare var $: any;
declare var J: any;

class Members {
    readonly $content: any;

    constructor() {
        this.$content = $('#page-content');
        $.getJSON('./api/test/members').then(rows => {
            const $table = $('<table class="table table-striped table-hover"></table>');
            const $head = $('<thead><tr><th>(' + rows.length + ')</th><th>员工号</th><th>姓名</th></tr></thead>');
            $table.append($head);
            const $body = $('<tbody></tbody>');
            $table.append($body);
            rows.forEach((ele, i) => {
                const $tr = $('<tr><td>' + (i + 1) + '</td><td>' + ele.workcode + '</td><td>' + ele.name + '</td></tr>');
                $body.append($tr);
            });
            this.$content.empty();
            this.$content.append($table);
        });
    }
}