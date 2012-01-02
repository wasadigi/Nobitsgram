<%--
    Document   : settingAccount
    Created on : 11 déc. 2011, 16:47:24
    Author     : Eyram
--%>



<%@include file="tools/headPage.jspf" %>

<div class="bar" id="positionbar">

    <a href="<% out.print(root+ "/GalleryServlet"); %>" >
         <img class="" src="<% out.print(root+"/images/gallery.jpg");%>" class ="posipicto" /><span id="myText">Gallery </span></a>
     <a href="<% out.print(root+ "/view/settingAccount.jsp"); %>" class="selected">
            <img class="" src="<% out.print(root+"/images/account1.jpg");%>" class ="posipicto" /><span id="myText">My account</span></a>
     <a href="<% out.print(root+ "/FriendServlet"); %>">
            <img class="" src="<% out.print(root+"/images/friends3.jpg");%>" class ="posipicto"/><span id="myText">Friends</span></a>
     <a href="<% out.print(root+ "/MapServlet"); %>" >
             <img class="" src="<% out.print(root+"/images/map.jpg");%>" class ="posipicto"  /><span id="myText">Map</span></a>
     <a href="<%out.print(root+ "/LogoutServlet"); %>" id="">
             <img class="" src="<% out.print(root+"/images/logout1.jpg");%>" class ="posipicto" /><span id="myText">Logout</span></a>



        <form action="<% out.print(root+ "/SearchServlet"); %>" method="GET">
            <!-- Bare menu -->
            <div id="posearch">
                <table>
                    <tr>
                        <td>
                    <input type="text" name="searchTopic" value="" size="25">
                        </td>
                        <td>
                        <input type="image" src="<% out.print(root+"/images/search.jpg");%>"
                           style="width: 32px; height: 32px;" name="Submit" value="find">
                        </td>
                </tr>
                </table>
            </div>
 </form>

        </div>

        <%  User user = null;
            try{
                user = (User)request.getSession().getAttribute("user");
            }
            catch(Exception exc){ %>
            <jsp:forward page="/LogoutServlet">
                <jsp:param name="transfert" value="ok" />
            </jsp:forward>
                
           <% }
                    
            String firstname = user.getFirstname();
            String lastname = user.getLastname();
            String country = user.getCountry();
            String email = user.getEmail();
            List<Topic> topics = user.getTopicList();
            String username = user.getUsername();
            String streetNumber = user.getStreetNumber();
            String street = user.getStreet();
            String city = user.getCity();
            String zip = user.getZipCode();
            String error = (String)request.getAttribute("error");                   
            
            if(user.getStreetNumber()==null || streetNumber.equals("null")){
                streetNumber = "";                
            }
            if(user.getStreet()==null || street.equals("null")){
                street = "";
            }
            if(user.getCity()==null || city.equals("null")){
                city = "";
            }
            if(user.getZipCode()==null || zip.equals("null")){
                zip = "";
            }
            
            
        %>
        <div>
		<form  method="GET"  action="<% out.print(root+ "/ServletPersonnalPage"); %>">
                
                    <% if(error != null && error!="") { %>
                   <h3 style=" color:#BF0B0B; margin-top: 100px;text-align: center"> 
                       <% out.print(error);%> </h3>
                 <%}else{%>
                      <h2 style="margin-top: 100px;text-align: center"> 
                          <% out.print(username);%>, you can set your nobitsgram data here!<%}%> </h2>
        <table cellspacing="50"  bgcolor='#38B0DE' style="margin-left: 20%; margin-top: 20px;margin-bottom: 5%">

                        <tr>
				<td><label>Last name</label></td>
				<td><input type="text" name="lastname" value="<% out.print(lastname); %>" /></td>

			</tr>
			<tr>
				<td><label>First name</label></td>
                                <td><input type="text" name="firstname" value="<% out.print(firstname); %>" /></td>
			</tr>

                        <tr>
                            <td><label>Street number:</label></td>
                            <td><input name="streetNumber" size="8" 
                                      value="<% out.print(streetNumber); %>" type="text" /></td>
                        </tr>
                        <tr>
                            <td><label>Street address:</label></td>
                            <td><input name="street" size="30" 
                                      value="<% out.print(street); %>" type="text" /></td>
                        </tr>

                        <tr>
                            <td><label>city:</label></td>
                            <td><input name="city" size="30" 
                                      value="<% out.print(city); %>" type="text" /></td>
                        </tr>

                       <tr>
                           <td><label>ZIP/Postal Code:</label></td>
                           <td><input name="zip" size="8" 
                                     value="<% out.print(zip); %>" type="text" /></td>
                        </tr>

            <tr>
                <td><label class="label" for="country">Country</label></td>

                <td><select class="" id="country" name="country">
                        <hr/><option value="<% out.print(country); %>"><% out.print(country); %></option>
                        <option value="Afghanistan">Afghanistan</option>
			<option value="Aland Islands">Aland Islands</option>
			<option value="Albania">Albania</option>
			<option value="Algeria">Algeria</option>
			<option value="American Samoa">American Samoa</option>
			<option value="Andorra">Andorra</option>

			<option value="Angola">Angola</option>
			<option value="Anguilla">Anguilla</option>
			<option value="Antarctica">Antarctica</option>
			<option value="Antigua and Barbuda">Antigua and Barbuda</option>
			<option value="Argentina">Argentina</option>
			<option value="Armenia">Armenia</option>

			<option value="Aruba">Aruba</option>
			<option value="Australia">Australia</option>
			<option value="Austria">Austria</option>
			<option value="Azerbaijan">Azerbaijan</option>
			<option value="Bahamas">Bahamas</option>
			<option value="Bahrain">Bahrain</option>

			<option value="Bangladesh">Bangladesh</option>
			<option value="Barbados">Barbados</option>
			<option value="Belarus">Belarus</option>
			<option value="Belgium">Belgium</option>
			<option value="Belize">Belize</option>
			<option value="Benin">Benin</option>

			<option value="Bermuda">Bermuda</option>
			<option value="Bhutan">Bhutan</option>
			<option value="Bolivia">Bolivia</option>
			<option value="Bosnia and Herzegovina">Bosnia and Herzegovina</option>
			<option value="Botswana">Botswana</option>
			<option value="Bouvet Island">Bouvet Island</option>

			<option value="Brazil">Brazil</option>
			<option value="British Indian Ocean Territory">British Indian Ocean Territory</option>
			<option value="British Virgin Islands">British Virgin Islands</option>
			<option value="Brunei">Brunei</option>
			<option value="Bulgaria">Bulgaria</option>
			<option value="Burkina Faso">Burkina Faso</option>

			<option value="Burundi">Burundi</option>
			<option value="Cambodia">Cambodia</option>
			<option value="Cameroon">Cameroon</option>
			<option value="Canada">Canada</option>
			<option value="Cape Verde">Cape Verde</option>
			<option value="Cayman Islands">Cayman Islands</option>

			<option value="Central African Republic">Central African Republic</option>
			<option value="Chad">Chad</option>
			<option value="Chile">Chile</option>
			<option value="China">China</option>
			<option value="Christmas Island">Christmas Island</option>
			<option value="Cocos (Keeling) Islands">Cocos (Keeling) Islands</option>

			<option value="Colombia">Colombia</option>
			<option value="Comoros">Comoros</option>
			<option value="Congo">Congo</option>
			<option value="Cook Islands">Cook Islands</option>
			<option value="Costa Rica">Costa Rica</option>
			<option value="Croatia">Croatia</option>

			<option value="Cuba">Cuba</option>
			<option value="Cyprus">Cyprus</option>
			<option value="Czech Republic">Czech Republic</option>
			<option value="Democratic Republic of Congo">Democratic Republic of Congo</option>
			<option value="Denmark">Denmark</option>
			<option value="Disputed Territory">Disputed Territory</option>

			<option value="Djibouti">Djibouti</option>
			<option value="Dominica">Dominica</option>
			<option value="Dominican Republic">Dominican Republic</option>
			<option value="East Timor">East Timor</option>
			<option value="Ecuador">Ecuador</option>
			<option value="Egypt">Egypt</option>

			<option value="El Salvador">El Salvador</option>
			<option value="Equatorial Guinea">Equatorial Guinea</option>
			<option value="Eritrea">Eritrea</option>
			<option value="Estonia">Estonia</option>
			<option value="Ethiopia">Ethiopia</option>
			<option value="Falkland Islands">Falkland Islands</option>

			<option value="Faroe Islands">Faroe Islands</option>
			<option value="Federated States of Micronesia">Federated States of Micronesia</option>
			<option value="Fiji">Fiji</option>
			<option value="Finland">Finland</option>
			<option value="France">France</option>
			<option value="French Guyana">French Guyana</option>

			<option value="French Polynesia">French Polynesia</option>
			<option value="French Southern Territories">French Southern Territories</option>
			<option value="Gabon">Gabon</option>
			<option value="Gambia">Gambia</option>
			<option value="Georgia">Georgia</option>
			<option value="Germany">Germany</option>

			<option value="Ghana">Ghana</option>
			<option value="Gibraltar">Gibraltar</option>
			<option value="Greece">Greece</option>
			<option value="Greenland">Greenland</option>
			<option value="Grenada">Grenada</option>
			<option value="Guadeloupe">Guadeloupe</option>

			<option value="Guam">Guam</option>
			<option value="Guatemala">Guatemala</option>
			<option value="Guinea">Guinea</option>
			<option value="Guinea-Bissau">Guinea-Bissau</option>
			<option value="Guyana">Guyana</option>
			<option value="Haiti">Haiti</option>

			<option value="Heard Island and Mcdonald Islands">Heard Island and Mcdonald Islands</option>
			<option value="Honduras">Honduras</option>
			<option value="Hong Kong">Hong Kong</option>
			<option value="Hungary">Hungary</option>
			<option value="Iceland">Iceland</option>
			<option value="India">India</option>

			<option value="Indonesia">Indonesia</option>
			<option value="Iran">Iran</option>
			<option value="Iraq">Iraq</option>
			<option value="Iraq-Saudi Arabia Neutral Zone">Iraq-Saudi Arabia Neutral Zone</option>
			<option value="Ireland">Ireland</option>
			<option value="Israel">Israel</option>

			<option value="Italy">Italy</option>
			<option value="Ivory Coast">Ivory Coast</option>
			<option value="Jamaica">Jamaica</option>
			<option value="Japan">Japan</option>
			<option value="Jordan">Jordan</option>
			<option value="Kazakhstan">Kazakhstan</option>

			<option value="Kenya">Kenya</option>
			<option value="Kiribati">Kiribati</option>
			<option value="Kuwait">Kuwait</option>
			<option value="Kyrgyzstan">Kyrgyzstan</option>
			<option value="Laos">Laos</option>
			<option value="Latvia">Latvia</option>

			<option value="Lebanon">Lebanon</option>
			<option value="Lesotho">Lesotho</option>
			<option value="Liberia">Liberia</option>
			<option value="Libya">Libya</option>
			<option value="Liechtenstein">Liechtenstein</option>
			<option value="Lithuania">Lithuania</option>

			<option value="Luxembourg">Luxembourg</option>
			<option value="Macau">Macau</option>
			<option value="Macedonia">Macedonia</option>
			<option value="Madagascar">Madagascar</option>
			<option value="Malawi">Malawi</option>
			<option value="Malaysia">Malaysia</option>

			<option value="Maldives">Maldives</option>
			<option value="Mali">Mali</option>
			<option value="Malta">Malta</option>
			<option value="Marshall Islands">Marshall Islands</option>
			<option value="Martinique">Martinique</option>
			<option value="Mauritania">Mauritania</option>

			<option value="Mauritius">Mauritius</option>
			<option value="Mayotte">Mayotte</option>
			<option value="Mexico">Mexico</option>
			<option value="Moldova">Moldova</option>
			<option value="Monaco">Monaco</option>
			<option value="Mongolia">Mongolia</option>

			<option value="Montserrat">Montserrat</option>
			<option value="Morocco">Morocco</option>
			<option value="Mozambique">Mozambique</option>
			<option value="Myanmar">Myanmar</option>
			<option value="Namibia">Namibia</option>
			<option value="Nauru">Nauru</option>

			<option value="Nepal">Nepal</option>
			<option value="Netherlands">Netherlands</option>
			<option value="Netherlands Antilles">Netherlands Antilles</option>
			<option value="New Caledonia">New Caledonia</option>
			<option value="New Zealand">New Zealand</option>
			<option value="Nicaragua">Nicaragua</option>

			<option value="Niger">Niger</option>
			<option value="Nigeria">Nigeria</option>
			<option value="Niue">Niue</option>
			<option value="Norfolk Island">Norfolk Island</option>
			<option value="North Korea">North Korea</option>
			<option value="Northern Mariana Islands">Northern Mariana Islands</option>

			<option value="Norway">Norway</option>
			<option value="Oman">Oman</option>
			<option value="Pakistan">Pakistan</option>
			<option value="Palau">Palau</option>
			<option value="Palestinian Territories">Palestinian Territories</option>
			<option value="Panama">Panama</option>

			<option value="Papua New Guinea">Papua New Guinea</option>
			<option value="Paraguay">Paraguay</option>
			<option value="Peru">Peru</option>
			<option value="Philippines">Philippines</option>
			<option value="Pitcairn Islands">Pitcairn Islands</option>
			<option value="Poland">Poland</option>

			<option value="Portugal">Portugal</option>
			<option value="Puerto Rico">Puerto Rico</option>
			<option value="Qatar">Qatar</option>
			<option value="Reunion">Reunion</option>
			<option value="Romania">Romania</option>
			<option value="Russia">Russia</option>

			<option value="Rwanda">Rwanda</option>
			<option value="Saint Helena and Dependencies">Saint Helena and Dependencies</option>
			<option value="Saint Kitts and Nevis">Saint Kitts and Nevis</option>
			<option value="Saint Lucia">Saint Lucia</option>
			<option value="Saint Pierre and Miquelon">Saint Pierre and Miquelon</option>
			<option value="Saint Vincent and the Grenadines">Saint Vincent and the Grenadines</option>

			<option value="Samoa">Samoa</option>
			<option value="San Marino">San Marino</option>
			<option value="Sao Tome and Principe">Sao Tome and Principe</option>
			<option value="Saudi Arabia">Saudi Arabia</option>
			<option value="Senegal">Senegal</option>
			<option value="Seychelles">Seychelles</option>

			<option value="Sierra Leone">Sierra Leone</option>
			<option value="Singapore">Singapore</option>
			<option value="Slovakia">Slovakia</option>
			<option value="Slovenia">Slovenia</option>
			<option value="Solomon Islands">Solomon Islands</option>
			<option value="Somalia">Somalia</option>

			<option value="South Africa">South Africa</option>
			<option value="South Georgia and South Sandwich Islands">South Georgia and South Sandwich Islands</option>
			<option value="South Korea">South Korea</option>
			<option value="Spain">Spain</option>
			<option value="Spratly Islands">Spratly Islands</option>
			<option value="Sri Lanka">Sri Lanka</option>

			<option value="Sudan">Sudan</option>
			<option value="Suriname">Suriname</option>
			<option value="Svalbard and Jan Mayen">Svalbard and Jan Mayen</option>
			<option value="Swaziland">Swaziland</option>
			<option value="Sweden">Sweden</option>
			<option value="Switzerland">Switzerland</option>

			<option value="Syria">Syria</option>
			<option value="Taiwan">Taiwan</option>
			<option value="Tajikistan">Tajikistan</option>
			<option value="Tanzania">Tanzania</option>
			<option value="Thailand">Thailand</option>
			<option value="Togo">Togo</option>

			<option value="Tokelau">Tokelau</option>
			<option value="Tonga">Tonga</option>
			<option value="Trinidad and Tobago">Trinidad and Tobago</option>
			<option value="Tunisia">Tunisia</option>
			<option value="Turkey">Turkey</option>
			<option value="Turkmenistan">Turkmenistan</option>

			<option value="Turks And Caicos Islands">Turks And Caicos Islands</option>
			<option value="Tuvalu">Tuvalu</option>
			<option value="Uganda">Uganda</option>
			<option value="Ukraine">Ukraine</option>
			<option value="United Arab Emirates">United Arab Emirates</option>
			<option value="United Kingdom">United Kingdom</option>

			<option value="United States">United States</option>
			<option value="United States Minor Outlying Islands">United States Minor Outlying Islands</option>
			<option value="Uruguay">Uruguay</option>
			<option value="US Virgin Islands">US Virgin Islands</option>
			<option value="Uzbekistan">Uzbekistan</option>
			<option value="Vanuatu">Vanuatu</option>

			<option value="Vatican City">Vatican City</option>
			<option value="Venezuela">Venezuela</option>
			<option value="Vietnam">Vietnam</option>
			<option value="Wallis and Futuna">Wallis and Futuna</option>
			<option value="Western Sahara">Western Sahara</option>
			<option value="Yemen">Yemen</option>

			<option value="Zambia">Zambia</option>
			<option value="Zimbabwe">Zimbabwe</option>
			<option value="Serbia">Serbia</option>
			<option value="Montenegro">Montenegro</option>
               </select>
        </td>
        <td><label></label></td>
            </tr>

            <tr>
				<td><label for="email" id="email">Email </label></td>
				<td><input type="text" name="email"
                                           value="<% out.print(email); %>" /></td>
			</tr>
			<tr>
				<td><label>Password </label></td>
				<td><input type="password" name="password"/></td>

			</tr>
			<tr>
				<td><label>Confirm your password </label></td>
				<td><input type="password" name="passwordConfirm"/></td>

			</tr>


                         <%
                            int size = topics.size();
                            for(int i = 0; i < size; i++){

                            %>
                            <tr>
                            <td><label name="Topic">Topic <% out.print(" "+(i+1)); %></label></td>
                            <td><input name="topic<%out.print(i);%>" type="text"
                                       value="<% out.print(topics.get(i).getName()); %>" /></td>

                            <td>
                                <button type="submit" name="action" value="<%out.print(i);%>">
                                    remove</button>

                            </td>

                        </tr>
                        <% } %>


                                <tr>


                                    <td>

                                    </td>
                                    <td><label>(for more than one topic, separate each with ",")</label></td>
                                    <td>

                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label>Topics:</label>
                                    </td>
                                    <td><input name="rawTopic" size="30" type="text" /></td>
                                    <td>

                                    </td>
                                </tr>


                        <tr>
                             <td>

				</td>
                                <td>
                                    <input type="submit" style="border:1px solid #f6b22b;
                                    background:#fbe26eE;width:200px;
                                    background-color:#F7D92E;
                                    height: 35px;font-size:18px;" name="action" value="Submit" />
                                </td>
				<td>

                                </td>
			</tr>
                    </table>

		</form>

	</div>


<%@include file="tools/footPage.jspf" %>

