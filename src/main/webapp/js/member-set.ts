declare var $: any;
declare var J: any;

class MemberSet {
    readonly $content: any;

    constructor() {
        this.$content = $('#page-content');
    }

    protected fillData(res: any[]) {
        const $navTabs = $('<ul class="nav nav-tabs"></ul>');
        const $tabContents = $('<div class="tab-content"></div>');
        res.forEach((sheet, i) => {
            const tabContentId = 'tabContent' + i;
            const $navTab = $('<li><a href="javascript;" data-target="#' + tabContentId + '" data-toggle="tab">' + sheet.sheetName + '</a></li>');
            $navTabs.append($navTab);
            const $tabContent = $('<div class="tab-pane fade" id="' + tabContentId + '"></div>');
            $tabContent.append(this.generateMemberTable(sheet.rows));
            $tabContents.append($tabContent);
            if (i === 0) {
                $navTab.addClass('active');
                $tabContent.addClass('active in');
            }
        });
        this.$content.empty();
        this.$content.append($navTabs);
        this.$content.append($tabContents);
    }

    protected generateMemberTable(rows: any[]) {
        const $table = $('<table class="table table-striped table-hover"></table>');
        const $head = $('<thead></thead>');
        $table.append($head);
        const $body = $('<tbody></tbody>');
        $table.append($body);
        rows.forEach((ele, i) => {
            if (i === 0) {
                const $tr = $('<tr><th>' + ele.hrId + '</th><th>' + ele.name + '</th></tr>');
                $head.append($tr);
            } else {
                const $tr = $('<tr><td>' + ele.hrId + '</td><td>' + ele.name + '</td></tr>');
                $body.append($tr);
            }
        });
        return $table;
    }
}

class WhiteSetPage extends MemberSet {
    constructor() {
        super();
        $('#uploader-white-set').uploader({
            autoUpload: true,
            url: './api/uploads/whiteSet',
            responseHandler: (res) => this.fillData(JSON.parse(res.response))
        });
        $.getJSON('./api/uploads/whiteSet').then(res => this.fillData(res));
    }
}

class BlackSetPage extends MemberSet {
    constructor() {
        super();
        $('#uploader-black-set').uploader({
            autoUpload: true,
            url: './api/uploads/blackSet',
            responseHandler: (res) => this.fillData(JSON.parse(res.response))
        });
        $.getJSON('./api/uploads/blackSet').then(res => this.fillData(res));
    }
}