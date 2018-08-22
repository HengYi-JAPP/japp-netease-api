package com.hengyi.japp.netease.application.internal;

import com.fasterxml.jackson.databind.type.CollectionType;
import com.github.ixtf.japp.core.J;
import com.github.ixtf.japp.poi.Jpoi;
import com.google.common.collect.Sets;
import com.hengyi.japp.netease.application.ConfigService;
import com.hengyi.japp.netease.interfaces.oa.OaService;
import com.hengyi.japp.netease.interfaces.oa.dto.OaCompany;
import com.hengyi.japp.netease.interfaces.oa.dto.OaDepartment;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.inject.Inject;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static com.github.ixtf.japp.core.Constant.MAPPER;
import static com.hengyi.japp.netease.Constant.*;

@Singleton
public class ConfigServiceImpl implements ConfigService {
    private Set<Integer> companies = Sets.newHashSet();
    private Set<Integer> departments = Sets.newHashSet();
    @Inject
    private OaService oaService;

    @PostConstruct
    void PostConstruct() {
        try {
            final CollectionType type = MAPPER.getTypeFactory().constructCollectionType(HashSet.class, Integer.class);
            File file = FileUtils.getFile(COMPANIES_PATH);
            companies = MAPPER.readValue(file, type);
            file = FileUtils.getFile(DEPARTMENTS_PATH);
            departments = MAPPER.readValue(file, type);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PreDestroy
    void PreDestroy() {
        try {
            File file = FileUtils.getFile(DEPARTMENTS_PATH);
            FileUtils.write(file, MAPPER.writeValueAsString(departments));
            file = FileUtils.getFile(COMPANIES_PATH);
            FileUtils.write(file, MAPPER.writeValueAsString(companies));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addCompany(Integer id) {
        companies.add(id);
    }

    @Override
    public void removeCompany(Integer id) {
        companies.remove(id);
    }

    @Override
    public Stream<OaCompany> listCompany() {
        return companies.stream()
                .map(oaService::findCompany)
                .filter(Objects::nonNull);
    }

    @Override
    public void addDepartment(Integer id) {
        departments.add(id);
    }

    @Override
    public void removeDepartment(Integer id) {
        departments.remove(id);
    }

    @Override
    public Stream<OaDepartment> listDepartment() {
        return departments.stream()
                .map(oaService::findDepartment)
                .filter(Objects::nonNull);
    }

    @Override
    public Stream<String> listWhiteSet() throws Exception {
        return xlsxHrIds(WHITE_SET_PATH);
    }

    private Stream<String> xlsxHrIds(String path) throws IOException {
        try (Workbook wb = new XSSFWorkbook(path)) {
            return IntStream.range(0, wb.getNumberOfSheets())
                    .mapToObj(wb::getSheetAt)
                    .flatMap(sheet -> StreamSupport.stream(sheet.spliterator(), false)
                            //跳过第一行
                            .skip(1)
                            .map(row -> row.getCell(0))
                            .map(Jpoi::stringValue)
                            .filter(J::nonBlank)
                    );
        }
    }

    @Override
    public Stream<String> listBlackSet() throws Exception {
        return xlsxHrIds(BLACK_SET_PATH);
    }
}
