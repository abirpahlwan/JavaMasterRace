import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class FOTWClass2 extends JFrame{
	private JList<Object> list, favlist, leftlist, rightlist;
	private JComboBox<String> box;
	private JLabel picture, favpicture;
	private JButton addbtn;
	private JPanel allpan, favpan, editfavpan;
	private static String[] countrynames = {"Afghanistan.png",
"Aktori.png",
"Aland Islands.png",
"Albania.png",
"Algeria.png",
"American Samoa.png",
"Andorra.png",
"Angola.png",
"Anguilla.png",
"Antarctica.png",
"Antigua and Barbuda.png",
"Argentina.png",
"Armenia.png",
"Aruba.png",
"Ashmore and Cartier Islands.png",
"Australia.png",
"Austria.png",
"Azerbaijan.png",
"Bahamas, The.png",
"Bahrain.png",
"Bangladesh.png",
"Barbados.png",
"Belarus.png",
"Belgium.png",
"Belize.png",
"Benin.png",
"Bermuda.png",
"Bhutan.png",
"Bolivia.png",
"Bonaire, Saint Eustatius and Saba.png",
"Bosnia and Herzegovina.png",
"Botswana.png",
"Bouvet Island.png",
"Brazil.png",
"British Indian Ocean Territory.png",
"British Virgin Islands.png",
"Brunei.png",
"Bulgaria.png",
"Burkina Faso.png",
"Burma.png",
"Burundi.png",
"Cambodia.png",
"Cameroon.png",
"Canada.png",
"Cape Verde.png",
"Cayman Islands.png",
"Central African Republic.png",
"Chad.png",
"Chile.png",
"China.png",
"Christmas Island.png",
"Clipperton Island.png",
"Cocos (Keeling) Islands.png",
"Colombia.png",
"Comoros.png",
"Congo, Democratic Republic of the.png",
"Congo, Republic of the.png",
"Cook Islands.png",
"Coral Sea Islands.png",
"Costa Rica.png",
"Cote d'Ivoire.png",
"Croatia.png",
"Cuba.png",
"Curacao.png",
"Cyprus.png",
"Czech Republic.png",
"Denmark.png",
"Dhekelia.png",
"Djibouti.png",
"Dominica.png",
"Dominican Republic.png",
"Ecuador.png",
"Egypt.png",
"El Salvador.png",
"England.png",
"Equatorial Guinea.png",
"Eritrea.png",
"Estonia.png",
"Ethiopia.png",
"European Union.png",
"Falkland Islands (Islas Malvinas).png",
"Faroe Islands.png",
"Fiji.png",
"Finland.png",
"France.png",
"French Guiana.png",
"French Polynesia.png",
"French Southern and Antarctic Lands.png",
"Gabon.png",
"Gambia, The.png",
"Georgia.png",
"Germany.png",
"Ghana.png",
"Gibraltar.png",
"Greece.png",
"Greenland.png",
"Grenada.png",
"Guam.png",
"Guatemala.png",
"Guernsey.png",
"Guinea.png",
"Guinea-Bissau.png",
"Guyana.png",
"Haiti.png",
"Heard Island and McDonald Islands.png",
"Holy See (Vatican City).png",
"Honduras.png",
"Hong Kong.png",
"Hungary.png",
"Iceland.png",
"India.png",
"Indonesia.png",
"Iran.png",
"Iraq.png",
"Ireland.png",
"Isle of Man.png",
"Israel.png",
"Italy.png",
"Jamaica.png",
"Jan Mayen.png",
"Japan.png",
"Jersey.png",
"Jordan.png",
"Kazakhstan.png",
"Kenya.png",
"Kiribati.png",
"Korea, North.png",
"Korea, South.png",
"Kosovo.png",
"Kuwait.png",
"Kyrgyzstan.png",
"Laos.png",
"Latvia.png",
"Lebanon.png",
"Lesotho.png",
"Liberia.png",
"Libya.png",
"Liechtenstein.png",
"Lithuania.png",
"Luxembourg.png",
"Macau.png",
"Macedonia.png",
"Madagascar.png",
"Malawi.png",
"Malaysia.png",
"Maldives.png",
"Mali.png",
"Malta.png",
"Marshall Islands.png",
"Mauritania.png",
"Mauritius.png",
"Mexico.png",
"Micronesia, Federated States of.png",
"Moldova.png",
"Monaco.png",
"Mongolia.png",
"Montenegro.png",
"Montserrat.png",
"Morocco.png",
"Mozambique.png",
"Namibia.png",
"Nauru.png",
"Navassa Island.png",
"Nepal.png",
"Netherlands.png",
"New Caledonia.png",
"New Zealand.png",
"Nicaragua.png",
"Niger.png",
"Nigeria.png",
"Niue.png",
"Norfolk Island.png",
"Northern Mariana Islands.png",
"Norway.png",
"Oman.png",
"Pakistan.png",
"Palau.png",
"Palestine.png",
"Panama.png",
"Papua New Guinea.png",
"Paraguay.png",
"Peru.png",
"Philippines.png",
"Pitcairn Islands.png",
"Poland.png",
"Portugal.png",
"Puerto Rico.png",
"Qatar.png",
"Romania.png",
"Russia.png",
"Rwanda.png",
"Saint Barthelemy.png",
"Saint Helena, Ascension, and Tristan da Cunha.png",
"Saint Kitts and Nevis.png",
"Saint Lucia.png",
"Saint Martin.png",
"Saint Pierre and Miquelon.png",
"Saint Vincent and the Grenadines.png",
"Samoa.png",
"San Marino.png",
"Sao Tome and Principe.png",
"Saudi Arabia.png",
"Scotland.png",
"Senegal.png",
"Serbia.png",
"Seychelles.png",
"Sierra Leone.png",
"Singapore.png",
"Sint Maarten.png",
"Slovakia.png",
"Slovenia.png",
"Solomon Islands.png",
"Somalia.png",
"South Africa.png",
"South Georgia and South Sandwich Islands.png",
"Spain.png",
"Sri Lanka.png",
"Sudan.png",
"Suriname.png",
"Svalbard.png",
"Swaziland.png",
"Sweden.png",
"Switzerland.png",
"Syria.png",
"Taiwan.png",
"Tajikistan.png",
"Tanzania.png",
"Thailand.png",
"Timor-Leste.png",
"Togo.png",
"Tokelau.png",
"Tonga.png",
"Trinidad and Tobago.png",
"Tunisia.png",
"Turkey.png",
"Turkmenistan.png",
"Turks and Caicos Islands.png",
"Tuvalu.png",
"Uganda.png",
"Ukraine.png",
"United Arab Emirates.png",
"United Kingdom.png",
"United States Pacific Island Wildlife Refuges.png",
"United States.png",
"Uruguay.png",
"Uzbekistan.png",
"Vanuatu.png",
"Venezuela.png",
"Vietnam.png",
"Virgin Islands.png",
"Wake Island.png",
"Wales.png",
"Wallis and Futuna.png",
"Western Sahara.png",
"Yemen.png",
"Zambia.png",
"Zimbabwe.png"};
	private static String[] select = {"All Countries", "Favourites", "Edit Favourites"};
	private Icon[] pics = new Icon[257];
	private Icon def = new ImageIcon(getClass().getResource("0.png"));
	
	public FOTWClass2(){
		super("Flags of the World");
		setLayout(new FlowLayout());
		
		for(int i=0; i<pics.length; i++){
			pics[i] = new ImageIcon(getClass().getResource(countrynames[i]));
		};
		
		allpan = new JPanel();
	
		list = new JList<Object> (countrynames);
		list.setVisibleRowCount(10);
		list.setFixedCellWidth(293);
		list.setFixedCellHeight(15);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		list.addListSelectionListener(
				new ListSelectionListener(){
					public void valueChanged(ListSelectionEvent event){
						picture.setIcon(pics[list.getSelectedIndex()]);
					}
				}
			);
		picture = new JLabel(def);
		allpan.add(new JScrollPane(list));
		allpan.add(picture);
		allpan.setVisible(true);
		
		
		favpan = new JPanel();
		
		favlist = new JList<Object>();
		favlist.setVisibleRowCount(10);
		favlist.setFixedCellWidth(308);
		favlist.setFixedCellHeight(15);
		favlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		favlist.addListSelectionListener(
				new ListSelectionListener(){
					public void valueChanged(ListSelectionEvent event){
						favpicture.setIcon(new ImageIcon(getClass().getResource((String) favlist.getSelectedValue())));
					}
				}
			);
		favpicture = new JLabel(def);
		favpan.add(new JScrollPane(favlist));
		favpan.add(favpicture);
		favpan.setVisible(false);
		
		
		editfavpan = new JPanel();
		
		leftlist = new JList<Object> (countrynames);
		leftlist.setVisibleRowCount(10);
		leftlist.setFixedCellWidth(129);
		leftlist.setFixedCellHeight(15);
		leftlist.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);		
		
		rightlist = new JList<Object>();
		rightlist.setVisibleRowCount(10);
		rightlist.setFixedCellWidth(129);
		rightlist.setFixedCellHeight(15);
		rightlist.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		addbtn = new JButton("Update >>");
		addbtn.setToolTipText("Upto 10 Countries");
		
		leftlist.addListSelectionListener(
				new ListSelectionListener(){
					public void valueChanged(ListSelectionEvent event){
						if(leftlist.getSelectedIndices().length > 10)
							addbtn.setEnabled(false);
						else
							addbtn.setEnabled(true);
					}
				}
			);
				
		addbtn.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						rightlist.setListData(leftlist.getSelectedValuesList().toArray());
						favlist.setListData(leftlist.getSelectedValuesList().toArray());
					}
				}
			);

		editfavpan.add(new JScrollPane(leftlist));
		editfavpan.add(addbtn);
		editfavpan.add(new JScrollPane(rightlist));
		editfavpan.setVisible(false);
		
		
		box = new JComboBox<String>(select);
		box.setPreferredSize(new Dimension(380,20));
		add(box);
		box.addItemListener(
				new ItemListener(){
					public void itemStateChanged(ItemEvent event){
						if(event.getStateChange()==ItemEvent.SELECTED)
							if(box.getSelectedIndex()==0){
								allpan.setVisible(true);
								favpan.setVisible(false);
								editfavpan.setVisible(false);
							}	
							else if(box.getSelectedIndex()==1){
								allpan.setVisible(false);
								favpan.setVisible(true);
								editfavpan.setVisible(false);
							}								
							else if(box.getSelectedIndex()==2){
								allpan.setVisible(false);
								favpan.setVisible(false);
								editfavpan.setVisible(true);
							}																												
					}
				}
		);
		
		add(allpan);
		add(favpan);
		add(editfavpan);
		
	}
}
