declare var $: any;
declare var J: any;

class CompaniesPage {
    readonly $content: any;
    readonly companyUpdateModal: CompanyUpdateModal;
    companies: any;

    constructor() {
        this.$content = $('#page-content');
        this.companyUpdateModal = new CompanyUpdateModal(this);
        $.getJSON('./api/configs/companies').then(res => {
            this.companies = res;
            this.refresh();
        });
    }

    refresh() {
        const $table = $('<table class="table table-striped table-hover"></table>');
        const $head = $('<thead><tr><th>(' + this.companies.length + ')</th><th>名称</th></tr></thead>');
        $table.append($head);
        const $body = $('<tbody></tbody>');
        $table.append($body);
        this.companies.forEach((company, i) => {
            const $tr = $('<tr><td>' + (i + 1) + '</td><td>' + company.subcompanyname + '</td></tr>');
            $tr.on('click', () => {
                if (window.confirm('删除?')) {
                    $.ajax({
                        type: 'DELETE',
                        url: './api/configs/companies/' + company.id,
                        contentType: 'application/json',
                        dataType: 'json',
                    }).then(() => {
                        this.companies = this.companies.filter(it => it.id !== company.id);
                        this.refresh();
                    });
                }
            });
            $body.append($tr);
        });
        this.$content.empty();
        this.$content.append($table);
    }

    isExist(company: any): boolean {
        return this.companies.find(it => it.id === company.id);
    }

    add(company: any) {
        this.companies.unshift(company);
        this.refresh();
    }

}

class CompanyUpdateModal {
    private readonly $modal: any;
    private readonly $modalBody: any;
    companies: any[];

    constructor(private readonly page: CompaniesPage) {
        this.$modal = $('#companyUpdateModal');
        this.$modalBody = this.$modal.find('.modal-body');
    }

    update() {
        $.getJSON('./api/oas/companies').then(res => {
            this.companies = res.filter(it => !this.page.isExist(it));
            this.$modalBody.empty();
            this.$modalBody.append(this.generateTable());
            this.$modal.modal({moveable: true, rememberPos: true});
        });
    }

    generateTable() {
        const $table = $('<table class="table table-striped table-hover"></table>');
        const $head = $('<thead><tr><th></th><th>名称</th></tr></thead>');
        $table.append($head);
        const $body = $('<tbody></tbody>');
        $table.append($body);
        this.companies.forEach((company, i) => {
            const $tr = $('<tr><td>' + (i + 1) + '</td><td>' + company.subcompanyname + '</td></tr>');
            $tr.on('click', () => {
                $.ajax({
                    type: 'PUT',
                    url: './api/configs/companies/' + company.id,
                    contentType: 'application/json',
                    dataType: 'json',
                }).then(() => {
                    $tr.toggle();
                    this.page.add(company);
                });
            });
            $body.append($tr);
        });
        return $table;
    }
}