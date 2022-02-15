package projetocriadouro.service;


import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

@Service
public class JasperService {

    private static final String JASPER_DIRETORIO = "classpath:jasper/";
    private static final String JASPER_PREFIXO_RELATORIO = "relatorioGeral-01";
    private static final String JASPER_PREFIXO_CERTIFICADO = "Camaragibe";
    private static final String JASPER_PREFIXO_GALADOR = "relatorioGalador";
    private static final String JASPER_SUFIXO = ".jasper";

    @Autowired
    private Connection connection;

    @Autowired
    private ResourceLoader resourceLoader;

    private Map<String, Object> params = new HashMap<>();

    public JasperService() {
        this.params.put("IMAGEM_DIRETORIO", JASPER_DIRETORIO);
    }

    public void adicionandoParamentro(String chave, Object valor){
        this.params.put(chave, valor);
    }

    public byte[] exportarCertificadoPDF() throws IOException, JRException {
        byte[] bytes = null;
        Resource resource = resourceLoader
                .getResource(JASPER_DIRETORIO.concat(JASPER_PREFIXO_CERTIFICADO).concat(JASPER_SUFIXO));
        InputStream stream = resource.getInputStream();
        JasperPrint print = JasperFillManager.fillReport(stream, params, connection);
        bytes = JasperExportManager.exportReportToPdf(print);

        return bytes;
    }

    public byte[] exportarRelatorioPDF() throws IOException, JRException {
        byte[] bytes = null;
        Resource resource = resourceLoader
                .getResource(JASPER_DIRETORIO.concat(JASPER_PREFIXO_RELATORIO).concat(JASPER_SUFIXO));
        InputStream stream = resource.getInputStream();
        JasperPrint print = JasperFillManager.fillReport(stream, params, connection);
        bytes = JasperExportManager.exportReportToPdf(print);

        return bytes;
    }

    public byte[] exportarRelatorioPDFGalador() throws IOException, JRException {
        byte[] bytes = null;
        Resource resource = resourceLoader
                .getResource(JASPER_DIRETORIO.concat(JASPER_PREFIXO_GALADOR).concat(JASPER_SUFIXO));
        InputStream stream = resource.getInputStream();
        JasperPrint print = JasperFillManager.fillReport(stream, params, connection);
        bytes = JasperExportManager.exportReportToPdf(print);

        return bytes;
    }
}
