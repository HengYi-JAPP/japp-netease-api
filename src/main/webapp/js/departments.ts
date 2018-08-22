declare var $: any;
declare var J: any;
declare var Rx: any;

class DepartmentsPage {
    readonly $content: any;
    readonly departmentUpdateModal: DepartmentUpdateModal;
    departments = [];

    constructor() {
        this.$content = $('#page-content');
        this.departmentUpdateModal = new DepartmentUpdateModal(this);
        $.getJSON('./api/configs/departments').then(res => {
            this.departments = res;
            this.refresh();
        });
    }

    refresh() {
        this.departments = this.departments.sort((o1, o2) => o1.fullPathName.localeCompare(o2.fullPathName));
        this.$content.empty();
        if (this.departments.length < 1) {
            return;
        }
        const $table = $('<table class="table table-striped table-hover"></table>');
        const $head = $('<thead><tr><th>(' + this.departments.length + ')</th><th>名称</th></tr></thead>');
        $table.append($head);
        const $body = $('<tbody></tbody>');
        $table.append($body);
        this.departments.forEach((department, i) => {
            const $tr = $('<tr><td>' + (i + 1) + '</td><td>' + department.fullPathName + '</td></tr>');
            $tr.on('click', () => {
                if (window.confirm('删除?')) {
                    $.ajax({
                        type: 'DELETE',
                        url: './api/configs/departments/' + department.id,
                        contentType: 'application/json',
                        dataType: 'json',
                    }).then(() => {
                        this.departments = this.departments.filter(it => it.id !== department.id);
                        this.refresh();
                    });
                }
            });
            $body.append($tr);
        });
        this.$content.append($table);
    }

    isExist(department: any): boolean {
        return this.departments.find(it => it.id === department.id);
    }

    add(department: any) {
        this.departments.unshift(department);
        this.refresh();
    }
}

class DepartmentUpdateModal {
    private readonly $modal: any;
    private readonly $modalBody: any;
    departments = [];

    constructor(private readonly page: DepartmentsPage) {
        this.$modal = $('#departmentUpdateModal');
        this.$modalBody = this.$modal.find('.modal-body');
        Rx.Observable.fromEvent(this.$modal.find('input[name="search"]'), 'keyup')
            .pluck('target', 'value')
            .debounce(500)
            .distinctUntilChanged()
            .filter(it => it)
            .subscribe(q => {
                console.log('test', q);
                $.getJSON('./api/oas/departments?q=' + q).then(res => {
                    this.departments = res.filter(it => !this.page.isExist(it));
                    this.refresh();
                });
            });
    }

    update() {
        this.refresh();
        this.$modal.modal({moveable: true, rememberPos: true, position: 40});
    }

    refresh() {
        this.$modalBody.empty();
        if (this.departments.length < 1) {
            return;
        }
        const $table = $('<table class="table table-striped table-hover"></table>');
        const $head = $('<thead><tr><th></th><th>名称</th></tr></thead>');
        $table.append($head);
        const $body = $('<tbody></tbody>');
        $table.append($body);
        this.departments.forEach((department, i) => {
            const $tr = $('<tr><td>' + (i + 1) + '</td><td>' + department.fullPathName + '</td></tr>');
            $tr.on('click', () => {
                $.ajax({
                    type: 'PUT',
                    url: './api/configs/departments/' + department.id,
                    contentType: 'application/json',
                    dataType: 'json',
                }).then(() => {
                    $tr.toggle();
                    this.page.add(department);
                });
            });
            $body.append($tr);
        });
        this.$modalBody.append($table);
    }
}