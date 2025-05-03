<!-- Font Awesome (si non déjà chargé) -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<footer class="footer_section bg-light text-dark pt-5">
   <div class="container">
      <div class="row">
         <!-- Colonne Contact -->
         <div class="col-md-4 footer-col">
            <div class="footer_contact">
               <h4>Contactez-nous</h4>
               <div class="contact_link_box">
                  <a href="#">
                     <i class="fa fa-map-marker" aria-hidden="true"></i>
                     <span>Maroc, Casablanca</span>
                  </a><br>
                  <a href="tel:+2125000607637">
                     <i class="fa fa-phone" aria-hidden="true"></i>
                     <span>Appeler : +212 (0)5000607637</span>
                  </a><br>
                  <a href="mailto:contact@gestiondepense.ma">
                     <i class="fa fa-envelope" aria-hidden="true"></i>
                     <span>contact@gestiondepense.ma</span>
                  </a>
               </div>
            </div>
         </div>

         <!-- Colonne Détail -->
         <div class="col-md-4 footer-col">
            <div class="footer_detail text-center">
               <a href="index.jsp" class="footer-logo h3 d-block mb-3">
                  <span style="color: #f7444e;">G</span>estion <span style="color: #f7444e;">D</span>épense
               </a>
               <p>
                  Bienvenue sur notre application. Nous nous engageons à fournir une gestion claire et efficace des dépenses.
               </p>
               <div class="footer_social mt-3">
                  <a href="https://facebook.com" target="_blank"><i class="fa fa-facebook"></i></a>
                  <a href="https://twitter.com" target="_blank"><i class="fa fa-twitter"></i></a>
                  <a href="https://linkedin.com" target="_blank"><i class="fa fa-linkedin"></i></a>
                  <a href="https://instagram.com" target="_blank"><i class="fa fa-instagram"></i></a>
                  <a href="https://pinterest.com" target="_blank"><i class="fa fa-pinterest"></i></a>
               </div>
            </div>
         </div>

         <!-- Colonne Carte -->
         <div class="col-md-4 footer-col">
            <div class="map_container">
               <div class="map">
                  <iframe 
                     src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3329.502209759963!2d-7.622929484800687!3d33.5898862807364!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0xda7cd6cf9a5f5f9%3A0x2fb8b5c40ddc4f02!2sCasablanca%2C%20Maroc!5e0!3m2!1sfr!2sma!4v1675878472346!5m2!1sfr!2sma" 
                     width="100%" 
                     height="200" 
                     style="border:0;" 
                     allowfullscreen="" 
                     loading="lazy">
                  </iframe>
               </div>
            </div>
         </div>
      </div>

      <!-- Infos -->
      <div class="footer-info text-center mt-4">
         <p class="text-muted">
            &copy; <%= java.time.Year.now() %> Tous droits réservés par <strong>Gestion Dépense</strong>
         </p>
      </div>
   </div>
</footer>
