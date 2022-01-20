/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knjigovodstveni_biro;

import java.text.SimpleDateFormat;
import java.sql.Date;
import alert.MyAlert;
import dao.BankaDAO;
import dao.IsplataDAO;
import dao.IzlaznaFakturaDAO;
import dao.KomitentDAO;
import dao.KomitentWrapperDAO;
import dao.MjestoDAO;
import dao.SamostalniPreduzetnikDAO;
import dao.SamostalniPreduzetnikImaKomitentaDAO;
import dto.SamostalniPreduzetnikDTO;
import dto.TipKomitentaDTO;
import dao.TipKomitentaDAO;
import dao.TipPrihodaDAO;
import dao.TipTroskaDAO;
import dao.UlaznaFakturaDAO;
import dao.UplataDAO;
import dto.BankaDTO;
import dto.IsplataDTO;
import dto.IzlaznaFakturaDTO;
import dto.UlaznaFakturaDTO;
import dto.KomitentDTO;
import dto.MjestoDTO;
import dto.TipPrihodaDTO;
import dto.TipTroskaDTO;
import dto.UplataDTO;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.util.StringConverter;
import dto.PDVprijavaDTO;
import dao.PDVPrijavaDAO;
import dto.KomitentWrapperDTO;
import java.util.List;
import javafx.scene.control.ContentDisplay;

/**
 * FXML Controller class
 *
 * @author Tijana Lakic
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private ComboBox<SamostalniPreduzetnikDTO> samostalniPreduzetnikComboBox;
    @FXML
    private TextField nazivIFTextField;
    @FXML
    private ComboBox<KomitentDTO> kupacComboBox;
    @FXML
    private TextField iznosIFTextField;
    @FXML
    private TextField osnovicaPDVTextField;
    @FXML
    private VBox dostavaVBox;
    @FXML
    private Button proknjiziIFButton;
    @FXML
    private DatePicker datumIFDate;
    @FXML
    private TextField ivsTextField;
    @FXML
    private TextField ioTextField;
    @FXML
    private ComboBox<TipPrihodaDTO> vrstaPrihodaComboBox;
    @FXML
    private TextField nazivUFTextField;
    @FXML
    private ComboBox<KomitentDTO> dobavljacComboBox;
    @FXML
    private TextField iznosBezPDVTextField;
    @FXML
    private TextField ipnTextField;
    @FXML
    private TextField upoTextField;
    @FXML
    private ComboBox<TipTroskaDTO> vrstaRashodaComboBox;
    @FXML
    private Button proknjiziUFButton;
    @FXML
    private CheckBox uvozCheckBox;
    @FXML
    private DatePicker datumUFDate;
    @FXML
    private TextField jibDobavljacaTextField;
    @FXML
    private TextField ukupnoSaPDVTextField;
    @FXML
    private TextField uupTextField;
    @FXML
    private TextField upnTextField;
    @FXML
    private CheckBox gotovinaCheckBox;
    @FXML
    private TableView<KomitentWrapperDTO> komitentiTableView;
    @FXML
    private TableColumn<KomitentWrapperDTO, String> jibTableColumn;
    @FXML
    private TableColumn<KomitentWrapperDTO, String> nazivTableColumn;
    @FXML
    private TableColumn<KomitentWrapperDTO, String> mjestoTableColumn;
    @FXML
    private TableColumn<KomitentWrapperDTO, String> ziroRacunTableColumn;
    @FXML
    private TableColumn<KomitentWrapperDTO, Double> saldoTableColumn;
    @FXML
    private ComboBox<TipKomitentaDTO> komitentComboBox;
    @FXML
    private TextField jibKomitentaTextField;
    @FXML
    private TextField nazivTextField;
    @FXML
    private TextField adresaTextField;
    @FXML
    private ComboBox<MjestoDTO> mjestoComboBox;
    @FXML
    private TextField telefonTextField;
    @FXML
    private Button dodajKomitentaButton;
    @FXML
    private TextField isporukeTextField;
    @FXML
    private TextField izvozTextField;
    @FXML
    private TextField ioppTextField;
    @FXML
    private TextField izlazniPDVTextField;
    @FXML
    private TextField uplpovrTextField;
    @FXML
    private Button generisiPDVprijavuButton;
    @FXML
    private TextField nabavkeTextField;
    private TextField uvpzTextField;
    @FXML
    private TextField vnpTextField;
    @FXML
    private TextField ulazniTextField;
    @FXML
    private TextField ioTextField111;
    @FXML
    private TextField pnzpTextField;
    @FXML
    private TextField ulazniUkupanPDVTextField;
    @FXML
    private DatePicker datumOdDate;
    @FXML
    private DatePicker datumDoDate;
    @FXML
    private TextField fbihTextField;
    @FXML
    private TextField rsTextField;
    @FXML
    private TextField bdTextField;
    @FXML
    private TableColumn<IsplataDTO, String> dobavljacTableColumn;
    @FXML
    private TableColumn<IsplataDTO, Date> datumIsplateTableColumn;
    @FXML
    private TableColumn<IsplataDTO, String> brojDokIsplateTableColumn;
    @FXML
    private TableColumn<IsplataDTO, Double> iznosIsplateTableColumn;
    @FXML
    private TableColumn<IsplataDTO, String> opisIsplateTableColumn;
    @FXML
    private TableColumn<IsplataDTO, String> bankaIsplateTableColumn;
    @FXML
    private TableColumn<IsplataDTO, Integer> vrstaRashodaTableColumn;
    @FXML
    private ComboBox<KomitentDTO> dobavljacComboBox1;
    @FXML
    private DatePicker datumIsplateDate1;
    @FXML
    private ComboBox<UlaznaFakturaDTO> fakturaUlaznaComboBox1;
    @FXML
    private TextField brojDokumentaTextField1;
    @FXML
    private TextField opisIsplateTextField1;
    @FXML
    private ComboBox<BankaDTO> bankaComboBox1;
    @FXML
    private ComboBox<TipTroskaDTO> vrstaRashodaComboBox1;
    @FXML
    private Button proknjiziIsplatuButton;
    @FXML
    private Button izmijeniIsplatuButton;
    @FXML
    private Button obrisiIsplatuButton;
    @FXML
    private ComboBox<KomitentDTO> kupacComboBox1;
    @FXML
    private DatePicker datumUplateDate1;
    @FXML
    private TextField brojDokumentaTextField2;
    @FXML
    private TextField iznosUplateTextField1;
    @FXML
    private ComboBox<BankaDTO> bankaComboBox2;
    @FXML
    private ComboBox<TipPrihodaDTO> vrstaPrihodaComboBox1;
    @FXML
    private Button proknjiziUplatuButton;
    @FXML
    private Button izmijeniUplatuButton;
    @FXML
    private Button obrisiUplatuButton;
    private ObservableList<SamostalniPreduzetnikDTO> samostalniPreduzetnici;
    private ObservableList<TipKomitentaDTO> tipKomitenta;
    private ObservableList<MjestoDTO> mjestoList;
    private ObservableList<BankaDTO> bankaList;
    private ObservableList<TipPrihodaDTO> tipPrihodaList;
    private ObservableList<TipTroskaDTO> tipRashodaList;
    private ObservableList<String> jibDobavljaciList;
    private ObservableList<String> jibKupciList;
    private ObservableList<UplataDTO> uplateList;
    private ObservableList<IsplataDTO> isplateList;
    private ObservableList<IzlaznaFakturaDTO> izlaznaFakturaList;
    private ObservableList<UlaznaFakturaDTO> ulaznaFakturaList;
    private ArrayList<KomitentDTO> kupciList;
    private ArrayList<KomitentDTO> dobavljaciList;
    @FXML
    private Button prikaziKomitenteButton;
    @FXML
    private ComboBox<TipKomitentaDTO> komitentComboBox11;
    @FXML
    private TextField ziroRacunTextField1;
    @FXML
    private CheckBox PDVSistemCheckBox;
    @FXML
    private ComboBox<BankaDTO> bankaComboBox;
    @FXML
    private TableView<UplataDTO> uplataTableView;
    @FXML
    private TableColumn<UplataDTO, String> kupacTableColumn1;
    @FXML
    private TableColumn<UplataDTO, Date> datumUplateTableColumn1;
    @FXML
    private TableColumn<UplataDTO, String> brojDokIUplateTableColumn1;
    @FXML
    private TableColumn<UplataDTO, Double> iznosUplateTableColumn1;
    @FXML
    private TableColumn<UplataDTO, String> opisUplateTableColumn1;
    @FXML
    private TableColumn<UplataDTO, String> bankaUplateTableColumn1;
    @FXML
    private TableColumn<UplataDTO, Integer> vrstaPrihodaTableColumn1;
    @FXML
    private ComboBox<IzlaznaFakturaDTO> fakturaIzlaznaComboBox1;
    @FXML
    private TextField opisUplateTextField1;
    @FXML
    private TableView<IsplataDTO> isplataTableView;
    @FXML
    private Tab uplataTab;
    @FXML
    private TextField iznosIsplateTextField1;
    private UplataDTO uplataTableViewSelected;
    private IsplataDTO isplataTableViewSelected;
    @FXML
    private TextField iznosIzvozaTextField;
    @FXML
    private TextField jibKupcaTextField;
    @FXML
    private TextField updvTextField1;
    @FXML
    private TextField uvozTextField;
    @FXML
    private Tab pdvPrijavaTab;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        samostalniPreduzetnici = SamostalniPreduzetnikDAO.getSamostalnePreduzetnike();
        samostalniPreduzetnikComboBox.setItems(FXCollections.observableArrayList(samostalniPreduzetnici));

        samostalniPreduzetnikComboBox.setConverter(new StringConverter<SamostalniPreduzetnikDTO>() {

            @Override
            public String toString(SamostalniPreduzetnikDTO object) {
                return object.getNaziv();
            }

            @Override
            public SamostalniPreduzetnikDTO fromString(String string) {
                return samostalniPreduzetnikComboBox.getItems().stream().filter(ap
                        -> ap.getNaziv().equals(string)).findFirst().orElse(null);
            }
        });

        tipKomitenta = TipKomitentaDAO.getTipoveKomitenata();
        StringConverter<TipKomitentaDTO> tipKomitentaConverter = new StringConverter<TipKomitentaDTO>() {

            @Override
            public String toString(TipKomitentaDTO object) {
                return object.getNazivTipa();
            }

            @Override
            public TipKomitentaDTO fromString(String string) {
                return komitentComboBox.getItems().stream().filter(ap
                        -> ap.getNazivTipa().equals(string)).findFirst().orElse(null);
            }
        };
        komitentComboBox.setItems(FXCollections.observableArrayList(tipKomitenta));
        komitentComboBox.setConverter(tipKomitentaConverter);
        komitentComboBox11.setItems(FXCollections.observableArrayList(tipKomitenta));
        komitentComboBox11.setConverter(tipKomitentaConverter);

        mjestoList = MjestoDAO.getMjesta();
        mjestoComboBox.setItems(FXCollections.observableArrayList(mjestoList));

        mjestoComboBox.setConverter(new StringConverter<MjestoDTO>() {

            @Override
            public String toString(MjestoDTO object) {
                return object.getNaziv();
            }

            @Override
            public MjestoDTO fromString(String string) {
                return mjestoComboBox.getItems().stream().filter(ap
                        -> ap.getNaziv().equals(string)).findFirst().orElse(null);
            }
        });
        StringConverter<BankaDTO> bankaConverter = new StringConverter<BankaDTO>() {

            @Override
            public String toString(BankaDTO object) {
                return object.getNazivBanke();
            }

            @Override
            public BankaDTO fromString(String string) {
                return bankaComboBox.getItems().stream().filter(ap
                        -> ap.getNazivBanke().equals(string)).findFirst().orElse(null);
            }
        };
        bankaList = BankaDAO.getBanke();
        bankaComboBox.setItems(FXCollections.observableArrayList(bankaList));
        bankaComboBox.setConverter(bankaConverter);
        bankaComboBox1.setItems(FXCollections.observableArrayList(bankaList));
        bankaComboBox1.setConverter(bankaConverter);
        bankaComboBox2.setItems(FXCollections.observableArrayList(bankaList));
        bankaComboBox2.setConverter(bankaConverter);

        tipPrihodaList = TipPrihodaDAO.getTipoviPrihoda();
        StringConverter<TipPrihodaDTO> tipPrihodaConverter = new StringConverter<TipPrihodaDTO>() {

            @Override
            public String toString(TipPrihodaDTO object) {
                return object.getNaziv();
            }

            @Override
            public TipPrihodaDTO fromString(String string) {
                return vrstaPrihodaComboBox.getItems().stream().filter(ap
                        -> ap.getNaziv().equals(string)).findFirst().orElse(null);
            }
        };
        vrstaPrihodaComboBox.setItems(FXCollections.observableArrayList(tipPrihodaList));
        vrstaPrihodaComboBox.setConverter(tipPrihodaConverter);
        vrstaPrihodaComboBox1.setItems(FXCollections.observableArrayList(tipPrihodaList));
        vrstaPrihodaComboBox1.setConverter(tipPrihodaConverter);
        tipRashodaList = TipTroskaDAO.getTipoviTroska();
        StringConverter<TipTroskaDTO> tipRashodaConverter = new StringConverter<TipTroskaDTO>() {

            @Override
            public String toString(TipTroskaDTO object) {
                return object.getNaziv();
            }

            @Override
            public TipTroskaDTO fromString(String string) {
                return vrstaRashodaComboBox.getItems().stream().filter(ap
                        -> ap.getNaziv().equals(string)).findFirst().orElse(null);
            }
        };
        vrstaRashodaComboBox.setItems(FXCollections.observableArrayList(tipRashodaList));
        vrstaRashodaComboBox.setConverter(tipRashodaConverter);
        vrstaRashodaComboBox1.setItems(FXCollections.observableArrayList(tipRashodaList));
        vrstaRashodaComboBox1.setConverter(tipRashodaConverter);
    }

    @FXML
    private void onProknjiziIFButtonClick(ActionEvent event) {
        String samostalniPreduzetnikJIB = samostalniPreduzetnikComboBox.getSelectionModel().getSelectedItem().getJib();

        if ("".equals(nazivIFTextField.getText())
                || "".equals(iznosIFTextField.getText())
                || "".equals(iznosIzvozaTextField.getText())
                || "".equals(osnovicaPDVTextField.getText())
                || "".equals(ivsTextField.getText())
                || "".equals(ioTextField.getText())
                || "".equals(updvTextField1.getText())
                || kupacComboBox.getSelectionModel().isEmpty()
                || vrstaPrihodaComboBox.getSelectionModel().isEmpty()
                || datumIFDate.getValue() == null) {

            MyAlert.display("Greška", "Niste unijeli sve potrebne podatke o isplati", "error");

        } else if (!Pattern.matches("[^-][0-9]*.?[0-9]*", iznosIFTextField.getText())
                || !Pattern.matches("[^-][0-9]*.?[0-9]*", iznosIzvozaTextField.getText())
                || !Pattern.matches("[^-][0-9]*.?[0-9]*", osnovicaPDVTextField.getText())
                || !Pattern.matches("[^-][0-9]*.?[0-9]*", ivsTextField.getText())
                || !Pattern.matches("[^-][0-9]*.?[0-9]*", ioTextField.getText())
                || !Pattern.matches("[^-][0-9]*.?[0-9]*", updvTextField1.getText())) {

            MyAlert.display("Greška", "Niste dobro unijeli podatke o iznosima/porezima", "error");

        } else {
            IzlaznaFakturaDAO izlaznaFaktura = new IzlaznaFakturaDAO();
            try {
                if (!izlaznaFaktura.setIzlaznaFaktura(
                        samostalniPreduzetnikJIB,
                        nazivIFTextField.getText(),
                        Date.valueOf(datumIFDate.getValue()),
                        kupacComboBox.getSelectionModel().getSelectedItem().getJib(),
                        Double.parseDouble(iznosIFTextField.getText()),
                        Double.parseDouble(ivsTextField.getText()),
                        Double.parseDouble(iznosIzvozaTextField.getText()),
                        Double.parseDouble(ioTextField.getText()),
                        Double.parseDouble(osnovicaPDVTextField.getText()),
                        Double.parseDouble(updvTextField1.getText()),
                        vrstaPrihodaComboBox.getSelectionModel().getSelectedItem().getId()
                )) {

                    MyAlert.display("Greška", "Greška prilikom upisa izlazne fakture u bazu.", "error");

                } else {
                    MyAlert.display("Obavještenje", "Uspješan upis izlazne fakture u bazu.", "info");

                }
            } catch (NumberFormatException e) {
                MyAlert.display("Greška", "Greška prilikom upisa u bazu.NumberFormatEX", "error");
            }

        }
    }



    @FXML
    private void onProknjiziUFButtonClick(ActionEvent event) {

        String samostalniPreduzetnikJIB = samostalniPreduzetnikComboBox.getSelectionModel().getSelectedItem().getJib();

        if ("".equals(nazivUFTextField.getText())
                || "".equals(iznosBezPDVTextField.getText())
                || "".equals(ipnTextField.getText())
                || "".equals(upoTextField.getText())
                || "".equals(uupTextField.getText())
                || "".equals(upnTextField.getText())
                || dobavljacComboBox.getSelectionModel().isEmpty()
                || vrstaRashodaComboBox.getSelectionModel().isEmpty()
                || datumUFDate.getValue() == null) {

            MyAlert.display("Greška", "Niste unijeli sve potrebne podatke o isplati", "error");

        } else if (!Pattern.matches("[^-][0-9]*.?[0-9]*", iznosBezPDVTextField.getText())
                || !Pattern.matches("[^-][0-9]*.?[0-9]*", ipnTextField.getText())
                || !Pattern.matches("[^-][0-9]*.?[0-9]*", upoTextField.getText())
                || !Pattern.matches("[^-][0-9]*.?[0-9]*", uupTextField.getText())
                || !Pattern.matches("[^-][0-9]*.?[0-9]*", upnTextField.getText())) {

            MyAlert.display("Greška", "Niste dobro unijeli podatke o iznosima/porezima", "error");

        } else {
            UlaznaFakturaDAO ulaznaFaktura = new UlaznaFakturaDAO();
            try {
                if (!ulaznaFaktura.setUlaznaFaktura(
                        samostalniPreduzetnikJIB,
                        nazivUFTextField.getText(),
                        Date.valueOf(datumUFDate.getValue()),
                        dobavljacComboBox.getSelectionModel().getSelectedItem().getJib(),
                        Double.parseDouble(iznosBezPDVTextField.getText()),
                        Double.parseDouble(ukupnoSaPDVTextField.getText()),
                        Double.parseDouble(ipnTextField.getText()),
                        Double.parseDouble(uupTextField.getText()),
                        Double.parseDouble(upoTextField.getText()),
                        Double.parseDouble(upnTextField.getText()),
                        vrstaRashodaComboBox.getSelectionModel().getSelectedItem().getId(),
                        uvozCheckBox.isSelected(),
                        gotovinaCheckBox.isSelected())) {

                    MyAlert.display("Greška", "Greška prilikom upisa ulazne fakture u bazu.", "error");

                } else {
                    MyAlert.display("Obavještenje", "Uspješan upis ulazne fakture u bazu.", "info");

                }
            } catch (NumberFormatException e) {
                MyAlert.display("Greška", "Greška prilikom upisa u bazu.NumberFormatEX", "error");
            }

            
        }
    }

    private void onUFTabSelectionChanged(Event event) {
        if (samostalniPreduzetnikComboBox.getSelectionModel().isEmpty()) {
            MyAlert.display("Greška", "Niste izabrali samostalnog preduzetnika za kojeg želite kreirati ulaznu fakturu.", "error");
        }
    }

    @FXML
    private void onDodajKomitentaButtonClick(ActionEvent event) {

        String samostalniPreduzetnikJIB = samostalniPreduzetnikComboBox.getSelectionModel().getSelectedItem().getJib();

        if ("".equals(jibKomitentaTextField.getText())
                || "".equals(nazivTextField.getText())
                || "".equals(adresaTextField.getText())
                || "".equals(ziroRacunTextField1.getText())
                || "".equals(telefonTextField.getText())
                || mjestoComboBox.getSelectionModel().isEmpty()
                || komitentComboBox11.getSelectionModel().isEmpty()
                || bankaComboBox.getSelectionModel().isEmpty()) {

            MyAlert.display("Greška", "Niste unijeli sve potrebne podatke", "error");

        } else if (!Pattern.matches("[0-9]{13}", jibKomitentaTextField.getText()) || !Pattern.matches("[0-9]{16}", ziroRacunTextField1.getText())
                || !Pattern.matches("[0-9]{13}", telefonTextField.getText())) {

            MyAlert.display("Greška", "Niste dobro unijeli podatke", "error");

        } else {
            KomitentWrapperDAO komitentWrapperDAO = new KomitentWrapperDAO();
            try {
                KomitentWrapperDTO komitent = komitentWrapperDAO.setKomitent(
                        samostalniPreduzetnikJIB,
                        jibKomitentaTextField.getText(),
                        nazivTextField.getText(),
                        PDVSistemCheckBox.isSelected(),
                        adresaTextField.getText(),
                        mjestoComboBox.getSelectionModel().getSelectedItem().getPostanskiBroj(),
                        telefonTextField.getText(),
                        ziroRacunTextField1.getText(),
                        komitentComboBox11.getSelectionModel().getSelectedItem().getIdTipa(),
                        bankaComboBox.getSelectionModel().getSelectedItem().getSifraBanke());
                
                 
            } catch (Exception e) {
                MyAlert.display("Greška", "Greška prilikom upisa u bazu", "error");
            }

            komitentiTableViewRefresh();
        }
    }


   

    @FXML
    private void onGenerisiPDVprijavuButtonClick(ActionEvent event
    ) {

        String samostalniPreduzetnikJIB = samostalniPreduzetnikComboBox.getSelectionModel().getSelectedItem().getJib();

        dao.PDVPrijavaDAO.executeStoredProcOUTParamsResulset(Date.valueOf(datumOdDate.getValue()),
                Date.valueOf(datumDoDate.getValue()), samostalniPreduzetnikJIB);

        dto.PDVprijavaDTO prijava = dao.PDVPrijavaDAO.prijava;

        isporukeTextField.setText(String.valueOf(prijava.getIsporuke()));
        izvozTextField.setText(String.valueOf(prijava.getIzvoz()));
        ioppTextField.setText(String.valueOf(prijava.getOslobodjen()));
        nabavkeTextField.setText(String.valueOf(prijava.getNabavke()));
        uvozTextField.setText(String.valueOf(prijava.getUvoz()));
        vnpTextField.setText(String.valueOf(prijava.getOslobodjen()));
        ulazniTextField.setText(String.valueOf(prijava.getPoljoprivrednik()));
        ioTextField111.setText(String.valueOf(prijava.getPdvUlaz()));
        pnzpTextField.setText(String.valueOf(prijava.getPdvUvoz()));
        ulazniUkupanPDVTextField.setText(String.valueOf(prijava.getPausalnaNaknada()));
        izlazniPDVTextField.setText(String.valueOf(prijava.getPdvIzlaz()));
        uplpovrTextField.setText(String.valueOf(prijava.getRazlikaIzlazUlaz()));
        fbihTextField.setText("0.00");
        rsTextField.setText(String.valueOf(prijava.getRs()));
        bdTextField.setText("0.00");
    }

    @FXML
    private void onProknjiziIsplatuButtonClick(ActionEvent event
    ) {

        String samostalniPreduzetnikJIB = samostalniPreduzetnikComboBox.getSelectionModel().getSelectedItem().getJib();

        if ("".equals(opisIsplateTextField1.getText())
                || "".equals(brojDokumentaTextField1.getText())
                || "".equals(iznosIsplateTextField1.getText())
                || dobavljacComboBox1.getSelectionModel().isEmpty()
                || fakturaUlaznaComboBox1.getSelectionModel().isEmpty()
                || bankaComboBox1.getSelectionModel().isEmpty()
                || vrstaRashodaComboBox1.getSelectionModel().isEmpty()
                || datumIsplateDate1.getValue().equals(null)) {

            MyAlert.display("Greška", "Niste unijeli sve potrebne podatke o isplati", "error");

        } else if (!Pattern.matches("[^-][0-9]*.?[0-9]*", iznosIsplateTextField1.getText())) {

            MyAlert.display("Greška", "Niste dobro unijeli podatke o iznosu", "error");

        } else {
            IsplataDAO isplata = new IsplataDAO();
            try {
                if (!isplata.setIsplata(
                        samostalniPreduzetnikJIB,
                        dobavljacComboBox1.getSelectionModel().getSelectedItem().getJib(),
                        Date.valueOf(datumIsplateDate1.getValue()),
                        fakturaUlaznaComboBox1.getSelectionModel().getSelectedItem().getId(),
                        brojDokumentaTextField1.getText(),
                        Double.parseDouble(iznosIsplateTextField1.getText()),
                        opisIsplateTextField1.getText(),
                        bankaComboBox1.getSelectionModel().getSelectedItem().getSifraBanke(),
                        vrstaRashodaComboBox1.getSelectionModel().getSelectedItem().getId())) {

                    MyAlert.display("Greška", "Greška prilikom upisa u bazu.", "error");

                } else {
                    MyAlert.display("Obavještenje", "Uspješan upis u bazu.", "info");

                }
            } catch (NumberFormatException e) {
                MyAlert.display("Greška", "Greška prilikom upisa u bazu.NumberFormatEX", "error");
            }

            isplataTableViewRefresh();
        }
    }

    @FXML
    private void onIzmijeniIsplatuButtonClick(ActionEvent event
    ) {
        if (isplataTableView.getSelectionModel().isEmpty()) {
            MyAlert.display("Greška", "Niste izabrali isplatu koju želite promjeniti.", "error");
        } else {

            String samostalniPreduzetnikJIB = samostalniPreduzetnikComboBox.getSelectionModel().getSelectedItem().getJib();

            if ("".equals(opisIsplateTextField1.getText())
                    || "".equals(brojDokumentaTextField1.getText())
                    || "".equals(iznosIsplateTextField1.getText())) {
                MyAlert.display("Greška", "Niste unijeli sve potrebne podatke o isplati", "error");
            } else if (!Pattern.matches("[^-][0-9]*.?[0-9]*", iznosIsplateTextField1.getText())) {
                MyAlert.display("Greška", "Niste dobro unijeli podatke o iznosu", "error");
            } else {
                IsplataDAO isplata = new IsplataDAO();
                try {
                    if (!isplata.updateIsplata(isplataTableViewSelected.getId(),
                            samostalniPreduzetnikJIB,
                            dobavljacComboBox1.getSelectionModel().getSelectedItem().getJib(),
                            Date.valueOf(datumIsplateDate1.getValue()),
                            fakturaUlaznaComboBox1.getSelectionModel().getSelectedItem().getId(),
                            brojDokumentaTextField1.getText(),
                            Double.parseDouble(iznosIsplateTextField1.getText()),
                            opisIsplateTextField1.getText(),
                            bankaComboBox1.getSelectionModel().getSelectedItem().getSifraBanke(),
                            vrstaRashodaComboBox1.getSelectionModel().getSelectedItem().getId())) {

                        MyAlert.display("Greška", "Greška prilikom upisa u bazu.", "error");

                    } else {

                        MyAlert.display("Obavještenje", "Uspjesna promjena u bazi.", "info");

                    }
                } catch (NumberFormatException e) {

                    MyAlert.display("Obavještenje", "Greška prilikom upisa u bazu.", "error");
                }
                isplataTableViewRefresh();
            }
        }
    }

    @FXML
    private void onObrisiIsplatuButtonClick(ActionEvent event
    ) {

        if (isplataTableView.getSelectionModel().isEmpty()) {
            MyAlert.display("Greška", "Niste izabrali isplatu koju želite obrisati.", "error");
        } else {
            IsplataDAO.removeIsplata(isplataTableViewSelected.getId());
            isplataTableViewRefresh();
        }
    }

    @FXML
    private void onIsplataTabSelectionChanged(Event event
    ) {
        if (samostalniPreduzetnikComboBox.getSelectionModel().isEmpty()) {
            MyAlert.display("Greška", "Niste izabrali samostalnog preduzetnika čije isplate želite vidjeti", "error");
        } else {
            String samostalniPreduzetnikJIB = samostalniPreduzetnikComboBox.getSelectionModel().getSelectedItem().getJib();
            dobavljacTableColumn.setCellValueFactory(new PropertyValueFactory<>("KomitentJIB"));
            datumIsplateTableColumn.setCellValueFactory(new PropertyValueFactory<>("Datum"));
            brojDokIsplateTableColumn.setCellValueFactory(new PropertyValueFactory<>("BrojDokumenta"));
            iznosIsplateTableColumn.setCellValueFactory(new PropertyValueFactory<>("Iznos"));
            opisIsplateTableColumn.setCellValueFactory(new PropertyValueFactory<>("Opis"));
            bankaIsplateTableColumn.setCellValueFactory(new PropertyValueFactory<>("SifraBanke"));
            vrstaRashodaTableColumn.setCellValueFactory(new PropertyValueFactory<>("IdTipaTroska"));
            isplateList = IsplataDAO.getIsplateBySP(samostalniPreduzetnikJIB);
            isplataTableView.setItems(FXCollections.observableArrayList(isplateList));
        }
    }

    @FXML
    private void onProknjiziUplatuButtonClick(ActionEvent event) throws IOException {
        String samostalniPreduzetnikJIB = samostalniPreduzetnikComboBox.getSelectionModel().getSelectedItem().getJib();

        if ("".equals(opisUplateTextField1.getText()) || "".equals(brojDokumentaTextField2.getText())
                || "".equals(iznosUplateTextField1.getText()) || kupacComboBox1.getSelectionModel().isEmpty()
                || fakturaIzlaznaComboBox1.getSelectionModel().isEmpty() || bankaComboBox2.getSelectionModel().isEmpty()
                || vrstaPrihodaComboBox1.getSelectionModel().isEmpty() || datumUplateDate1.getValue().equals(null)) {
            MyAlert.display("Greška", "Niste unijeli sve potrebne podatke o uplati", "error");
        } else if (!Pattern.matches("[^-][0-9]*.?[0-9]*", iznosUplateTextField1.getText())) {
            MyAlert.display("Greška", "Niste dobro unijeli podatke o iznosu", "error");
        } else {
            UplataDAO uplata = new UplataDAO();
            try {
                if (!uplata.setUplata(
                        samostalniPreduzetnikJIB,
                        kupacComboBox1.getSelectionModel().getSelectedItem().getJib(),
                        Date.valueOf(datumUplateDate1.getValue()),
                        fakturaIzlaznaComboBox1.getSelectionModel().getSelectedItem().getIdFakture(),
                        brojDokumentaTextField2.getText(),
                        Double.parseDouble(iznosUplateTextField1.getText()),
                        opisUplateTextField1.getText(),
                        bankaComboBox2.getSelectionModel().getSelectedItem().getSifraBanke(),
                        vrstaPrihodaComboBox1.getSelectionModel().getSelectedItem().getId())) {

                    MyAlert.display("Greška", "Greška prilikom upisa u bazu.", "error");

                } else {

                    MyAlert.display("Obavještenje", "Uspješan upis u bazu.", "info");

                }
            } catch (NumberFormatException e) {

                MyAlert.display("Obavještenje", "Greška prilikom upisa u bazu.", "error");
            }
            uplataTableViewRefresh();
        }
    }

    @FXML
    private void onIzmijeniUplatuButtonClick(ActionEvent event
    ) {

        if (uplataTableView.getSelectionModel().isEmpty()) {
            MyAlert.display("Greška", "Niste izabrali uplatu koju želite promjeniti.", "error");
        } else {

            String samostalniPreduzetnikJIB = samostalniPreduzetnikComboBox.getSelectionModel().getSelectedItem().getJib();

            if ("".equals(opisUplateTextField1.getText())
                    || "".equals(brojDokumentaTextField2.getText())
                    || "".equals(iznosUplateTextField1.getText())) {
                MyAlert.display("Greška", "Niste unijeli sve potrebne podatke o uplati", "error");
            } else if (!Pattern.matches("[^-][0-9]*.?[0-9]*", iznosUplateTextField1.getText())) {
                MyAlert.display("Greška", "Niste dobro unijeli podatke o iznosu", "error");
            } else {
                UplataDAO uplata = new UplataDAO();
                try {
                    if (!uplata.updateUplata(uplataTableViewSelected.getId(),
                            samostalniPreduzetnikJIB,
                            kupacComboBox1.getSelectionModel().getSelectedItem().getJib(),
                            Date.valueOf(datumUplateDate1.getValue()),
                            fakturaIzlaznaComboBox1.getSelectionModel().getSelectedItem().getIdFakture(),
                            brojDokumentaTextField2.getText(),
                            Double.parseDouble(iznosUplateTextField1.getText()),
                            opisUplateTextField1.getText(),
                            bankaComboBox2.getSelectionModel().getSelectedItem().getSifraBanke(),
                            vrstaPrihodaComboBox1.getSelectionModel().getSelectedItem().getId())) {

                        MyAlert.display("Greška", "Greška prilikom upisa u bazu.", "error");

                    } else {

                        MyAlert.display("Obavještenje", "Uspjesna promjena u bazi.", "info");

                    }
                } catch (NumberFormatException e) {

                    MyAlert.display("Obavještenje", "Greška prilikom upisa u bazu.", "error");
                }
                uplataTableViewRefresh();
            }
        }
    }

    @FXML
    private void onObrisiUplatuButtonClick(ActionEvent event
    ) {

        if (uplataTableView.getSelectionModel().isEmpty()) {
            MyAlert.display("Greška", "Niste izabrali uplatu koju želite obrisati.", "error");
        } else {
            UplataDAO.removeUplata(uplataTableViewSelected.getId());
            uplataTableViewRefresh();
        }
    }

    @FXML
    private void onUplataTabSelectionChanged(Event event
    ) {
        if (samostalniPreduzetnikComboBox.getSelectionModel().isEmpty()) {
            MyAlert.display("Greška", "Niste izabrali samostalnog preduzetnika čije uplate želite vidjeti", "error");
        } else {
            String samostalniPreduzetnikJIB = samostalniPreduzetnikComboBox.getSelectionModel().getSelectedItem().getJib();
            kupacTableColumn1.setCellValueFactory(new PropertyValueFactory<>("KomitentJIB"));
            datumUplateTableColumn1.setCellValueFactory(new PropertyValueFactory<>("Datum"));
            brojDokIUplateTableColumn1.setCellValueFactory(new PropertyValueFactory<>("BrojDokumenta"));
            iznosUplateTableColumn1.setCellValueFactory(new PropertyValueFactory<>("Iznos"));
            opisUplateTableColumn1.setCellValueFactory(new PropertyValueFactory<>("Opis"));
            bankaUplateTableColumn1.setCellValueFactory(new PropertyValueFactory<>("SifraBanke"));
            vrstaPrihodaTableColumn1.setCellValueFactory(new PropertyValueFactory<>("IdTipaPrihoda"));
            uplateList = UplataDAO.getUplateBySP(samostalniPreduzetnikJIB);
            uplataTableView.setItems(FXCollections.observableArrayList(uplateList));
        }
    }

    @FXML
    private void onSamostalniPreduzetnikComboBoxAction(ActionEvent event
    ) {
        String samostalniPreduzetnikJIB = samostalniPreduzetnikComboBox.getSelectionModel().getSelectedItem().getJib();
        jibDobavljaciList = SamostalniPreduzetnikImaKomitentaDAO.getKomitenteByTipandSP(1, samostalniPreduzetnikJIB);
        dobavljaciList = new ArrayList<KomitentDTO>();
        for (String jib : jibDobavljaciList) {
            dobavljaciList.add(KomitentDAO.getKomitentByJIB(jib));
        }
        jibKupciList = SamostalniPreduzetnikImaKomitentaDAO.getKomitenteByTipandSP(2, samostalniPreduzetnikJIB);
        kupciList = new ArrayList<>();
        jibKupciList.forEach((jib) -> {
            kupciList.add(KomitentDAO.getKomitentByJIB(jib));
        });
        StringConverter<KomitentDTO> komitentiConverter = new StringConverter<KomitentDTO>() {

            @Override
            public String toString(KomitentDTO object) {
                return object.getNaziv();
            }

            @Override
            public KomitentDTO fromString(String string) {
                return kupacComboBox.getItems().stream().filter(ap
                        -> ap.getNaziv().equals(string)).findFirst().orElse(null);
            }
        };
        kupacComboBox.setItems(FXCollections.observableArrayList(kupciList));
        kupacComboBox.setConverter(komitentiConverter);
        kupacComboBox1.setItems(FXCollections.observableArrayList(kupciList));
        kupacComboBox1.setConverter(komitentiConverter);
        dobavljacComboBox.setItems(FXCollections.observableArrayList(dobavljaciList));
        dobavljacComboBox.setConverter(komitentiConverter);
        dobavljacComboBox1.setItems(FXCollections.observableArrayList(dobavljaciList));
        dobavljacComboBox1.setConverter(komitentiConverter);
    }

    @FXML
    private void onPrikaziKomitentaButtonClick(ActionEvent event
    ) {
        String tipKomitenta = komitentComboBox.getSelectionModel().getSelectedItem().getNazivTipa();
        String samostalniPreduzetnikJIB = samostalniPreduzetnikComboBox.getSelectionModel().getSelectedItem().getJib();
        if (komitentComboBox.getSelectionModel().isEmpty()) {
            MyAlert.display("Greška", "Niste izabrali tip komitenta", "error");
        } else {
            jibTableColumn.setCellValueFactory(new PropertyValueFactory<>("jib"));
            nazivTableColumn.setCellValueFactory(new PropertyValueFactory<>("naziv"));
            mjestoTableColumn.setCellValueFactory(new PropertyValueFactory<>("mjesto"));
            ziroRacunTableColumn.setCellValueFactory(new PropertyValueFactory<>("ziroRacun"));
            saldoTableColumn.setCellValueFactory(new PropertyValueFactory<>("saldo"));

            ObservableList<KomitentWrapperDTO> komitenti = KomitentWrapperDAO.getKomitentiWrappersBySP(samostalniPreduzetnikJIB, tipKomitenta);

            komitentiTableView.setItems(FXCollections.observableArrayList(komitenti));

        }
    }

    @FXML
    private void kupacComboBox1OnAction(ActionEvent event
    ) {
        String samostalniPreduzetnikJIB = samostalniPreduzetnikComboBox.getSelectionModel().getSelectedItem().getJib();

        String komitentJIB = kupacComboBox1.getSelectionModel().getSelectedItem().getJib();

        izlaznaFakturaList = IzlaznaFakturaDAO.getIzlazneFaktureBySPAndKomitent(samostalniPreduzetnikJIB, komitentJIB);
        StringConverter<IzlaznaFakturaDTO> izlaznaFakturaConverter = new StringConverter<IzlaznaFakturaDTO>() {

            @Override
            public String toString(IzlaznaFakturaDTO object) {
                return object.getNazivFakture();
            }

            @Override
            public IzlaznaFakturaDTO fromString(String string) {
                return fakturaIzlaznaComboBox1.getItems().stream().filter(ap
                        -> ap.getNazivFakture().equals(string)).findFirst().orElse(null);
            }
        };
        fakturaIzlaznaComboBox1.setItems(FXCollections.observableArrayList(izlaznaFakturaList));
        fakturaIzlaznaComboBox1.setConverter(izlaznaFakturaConverter);

    }

    @FXML
    private void dobavljacComboBox1OnAction(ActionEvent event
    ) {

        String samostalniPreduzetnikJIB = samostalniPreduzetnikComboBox.getSelectionModel().getSelectedItem().getJib();

        String komitentJIB = dobavljacComboBox1.getSelectionModel().getSelectedItem().getJib();

        ulaznaFakturaList = UlaznaFakturaDAO.getUlazneFaktureBySPAndKomitent(samostalniPreduzetnikJIB, komitentJIB);
        StringConverter<UlaznaFakturaDTO> ulaznaFakturaConverter = new StringConverter<UlaznaFakturaDTO>() {

            @Override
            public String toString(UlaznaFakturaDTO object) {
                return object.getNazivFakture();
            }

            @Override
            public UlaznaFakturaDTO fromString(String string) {
                return fakturaUlaznaComboBox1.getItems().stream().filter(ap
                        -> ap.getNazivFakture().equals(string)).findFirst().orElse(null);
            }
        };
        fakturaUlaznaComboBox1.setItems(FXCollections.observableArrayList(ulaznaFakturaList));
        fakturaUlaznaComboBox1.setConverter(ulaznaFakturaConverter);

    }

    public void uplataTableViewRefresh() {
        String samostalniPreduzetnikJIB = samostalniPreduzetnikComboBox.getSelectionModel().
                getSelectedItem().getJib();
        uplateList = UplataDAO.getUplateBySP(samostalniPreduzetnikJIB);
        uplataTableView.setItems(FXCollections.observableArrayList(uplateList));

    }

    public void isplataTableViewRefresh() {
        String samostalniPreduzetnikJIB = samostalniPreduzetnikComboBox.getSelectionModel().
                getSelectedItem().getJib();
        isplateList = IsplataDAO.getIsplateBySP(samostalniPreduzetnikJIB);
        isplataTableView.setItems(FXCollections.observableArrayList(isplateList));

    }
    
    public void komitentiTableViewRefresh() {
        String samostalniPreduzetnikJIB = samostalniPreduzetnikComboBox.getSelectionModel().
                getSelectedItem().getJib();
        List<KomitentWrapperDTO> komitenti = KomitentWrapperDAO.getKomitentiWrappersBySP(samostalniPreduzetnikJIB, komitentComboBox.getSelectionModel().getSelectedItem().getNazivTipa());
        komitentiTableView.setItems(FXCollections.observableArrayList(komitenti));

    }

    @FXML
    private void isplataTableViewOnMouseClicked(MouseEvent event) {
        isplataTableViewSelected = isplataTableView.getSelectionModel().getSelectedItem();
        Date date = isplataTableViewSelected.getDatum();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        dobavljacComboBox1.setValue(KomitentDAO.getKomitentByJIB(isplataTableViewSelected.getKomitentJIB()));
        datumIsplateDate1.setValue(LocalDate.of(calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH)));
        fakturaUlaznaComboBox1.setValue(UlaznaFakturaDAO.
                getUlaznaFakturaById(isplataTableViewSelected.getUlaznaFakturaId()));
        brojDokumentaTextField1.setText(isplataTableViewSelected.getBrojDokumenta());
        bankaComboBox1.setValue(BankaDAO.getBankaBySifra(isplataTableViewSelected.getSifraBanke()));
        iznosIsplateTextField1.setText(String.valueOf(isplataTableViewSelected.getIznos()));
        opisIsplateTextField1.setText(isplataTableViewSelected.getOpis());
        vrstaRashodaComboBox1.setValue(TipTroskaDAO.
                getTipTroskaById(isplataTableViewSelected.getIdTipaTroska()));
    }

    @FXML
    private void uplataTableViewOnMouseClicked(MouseEvent event) {

        uplataTableViewSelected = uplataTableView.getSelectionModel().getSelectedItem();
        Date date = uplataTableViewSelected.getDatum();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        kupacComboBox1.setValue(KomitentDAO.getKomitentByJIB(uplataTableViewSelected.getKomitentJIB()));
        datumUplateDate1.setValue(LocalDate.of(calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH)));
        fakturaIzlaznaComboBox1.setValue(IzlaznaFakturaDAO.
                getIzlaznaFakturaById(uplataTableViewSelected.getIzlaznaFakturaId()));
        brojDokumentaTextField2.setText(uplataTableViewSelected.getBrojDokumenta());
        bankaComboBox2.setValue(BankaDAO.getBankaBySifra(uplataTableViewSelected.getSifraBanke()));
        iznosUplateTextField1.setText(String.valueOf(uplataTableViewSelected.getIznos()));
        opisUplateTextField1.setText(uplataTableViewSelected.getOpis());
        vrstaPrihodaComboBox1.setValue(TipPrihodaDAO.
                getTipPrihodaById(uplataTableViewSelected.getIdTipaPrihoda()));
    }

    @FXML
    private void dobavljacUlaznaFakturaOnAction(ActionEvent event) {

        jibDobavljacaTextField.setText(dobavljacComboBox.getSelectionModel().getSelectedItem().getJib());
        jibDobavljacaTextField.setEditable(false);
    }

    @FXML
    private void kupacIzlaznaFakturaOnAction(ActionEvent event) {

        jibKupcaTextField.setText(kupacComboBox.getSelectionModel().getSelectedItem().getJib());
        jibKupcaTextField.setEditable(false);

    }

}
