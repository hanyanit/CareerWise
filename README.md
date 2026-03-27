<img width="918" height="1296" alt="UML_Capstone_Final drawio" src="https://github.com/user-attachments/assets/88c3dcea-6b7b-4382-afe8-6e0d4e57ee8f" />
[UML_Capstone_Final.drawio](https://github.com/user-attachments/files/26302380/UML_Capstone_Final.drawio)
<mxfile host="app.diagrams.net" agent="Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:149.0) Gecko/20100101 Firefox/149.0" version="29.6.6">
  <diagram name="Page-1" id="2OVKpW6_SuNenMFWLGRL">
    <mxGraphModel dx="1158" dy="1421" grid="1" gridSize="10" guides="1" tooltips="1" connect="1" arrows="1" fold="1" page="1" pageScale="1" pageWidth="1169" pageHeight="827" math="0" shadow="0">
      <root>
        <mxCell id="0" />
        <mxCell id="1" parent="0" />
        <mxCell id="8AOcLPsy6JB6qDF-pSW3-5" parent="1" style="swimlane;whiteSpace=wrap;html=1;" value="User" vertex="1">
          <mxGeometry height="270" width="190" x="370" y="460" as="geometry">
            <mxRectangle height="30" width="70" x="30" y="80" as="alternateBounds" />
          </mxGeometry>
        </mxCell>
        <mxCell id="8AOcLPsy6JB6qDF-pSW3-17" parent="8AOcLPsy6JB6qDF-pSW3-5" style="text;html=1;whiteSpace=wrap;strokeColor=none;fillColor=none;align=center;verticalAlign=middle;rounded=0;" value="&lt;div align=&quot;left&quot;&gt;&lt;span&gt;- userid: int&lt;/span&gt;&lt;/div&gt;&lt;div align=&quot;left&quot;&gt;&lt;span&gt;-&amp;nbsp;&lt;/span&gt;&lt;span&gt;email: String&lt;/span&gt;&lt;/div&gt;&lt;div align=&quot;left&quot;&gt;&lt;span&gt;-&amp;nbsp;&lt;/span&gt;&lt;span&gt;password: String&lt;/span&gt;&lt;/div&gt;&lt;div align=&quot;left&quot;&gt;&lt;span&gt;-&amp;nbsp;&lt;/span&gt;&lt;span&gt;firstname: String&lt;/span&gt;&lt;/div&gt;&lt;div align=&quot;left&quot;&gt;&lt;span&gt;-&amp;nbsp;&lt;/span&gt;&lt;span&gt;lastname: String&lt;/span&gt;&lt;/div&gt;&lt;div align=&quot;left&quot;&gt;&lt;span&gt;-&amp;nbsp;&lt;/span&gt;&lt;span&gt;profilePicture: String&lt;/span&gt;&lt;/div&gt;&lt;div align=&quot;left&quot;&gt;&lt;span&gt;-&amp;nbsp;&lt;/span&gt;&lt;span&gt;phoneNumber: String&lt;/span&gt;&lt;/div&gt;&lt;div align=&quot;left&quot;&gt;&lt;span&gt;-&amp;nbsp;&lt;/span&gt;&lt;span&gt;location: String&lt;/span&gt;&lt;/div&gt;&lt;div&gt;&lt;span&gt;&lt;br&gt;&lt;/span&gt;&lt;/div&gt;" vertex="1">
          <mxGeometry height="140" width="140" x="10" y="40" as="geometry" />
        </mxCell>
        <mxCell id="8AOcLPsy6JB6qDF-pSW3-18" edge="1" parent="8AOcLPsy6JB6qDF-pSW3-5" style="endArrow=none;html=1;rounded=0;" value="">
          <mxGeometry height="50" relative="1" width="50" as="geometry">
            <mxPoint y="180" as="sourcePoint" />
            <mxPoint x="190" y="180" as="targetPoint" />
          </mxGeometry>
        </mxCell>
        <mxCell id="8AOcLPsy6JB6qDF-pSW3-20" parent="8AOcLPsy6JB6qDF-pSW3-5" style="text;html=1;whiteSpace=wrap;strokeColor=none;fillColor=none;align=center;verticalAlign=middle;rounded=0;" value="&lt;div align=&quot;left&quot;&gt;&lt;span&gt;+ register()&lt;/span&gt;&lt;/div&gt;&lt;div align=&quot;left&quot;&gt;&lt;span&gt;+ login()&lt;/span&gt;&lt;/div&gt;&lt;div align=&quot;left&quot;&gt;&lt;span&gt;+ updateProfile()&lt;/span&gt;&lt;/div&gt;&lt;div align=&quot;left&quot;&gt;&lt;span&gt;+ changePassword()&lt;/span&gt;&lt;/div&gt;&lt;br&gt;&lt;div&gt;&lt;span&gt;&lt;br&gt;&lt;/span&gt;&lt;/div&gt;" vertex="1">
          <mxGeometry height="96" width="120" x="20" y="190" as="geometry" />
        </mxCell>
        <mxCell id="8AOcLPsy6JB6qDF-pSW3-59" edge="1" parent="1" source="8AOcLPsy6JB6qDF-pSW3-7" style="edgeStyle=orthogonalEdgeStyle;rounded=0;orthogonalLoop=1;jettySize=auto;html=1;exitX=0;exitY=0.5;exitDx=0;exitDy=0;entryX=1;entryY=0.5;entryDx=0;entryDy=0;" target="8AOcLPsy6JB6qDF-pSW3-5">
          <mxGeometry relative="1" as="geometry" />
        </mxCell>
        <mxCell id="8AOcLPsy6JB6qDF-pSW3-70" edge="1" parent="1" source="8AOcLPsy6JB6qDF-pSW3-7" style="rounded=0;orthogonalLoop=1;jettySize=auto;html=1;exitX=0.75;exitY=0;exitDx=0;exitDy=0;entryX=0.75;entryY=1;entryDx=0;entryDy=0;shape=link;width=0.9090909090909083;" target="8AOcLPsy6JB6qDF-pSW3-9">
          <mxGeometry relative="1" as="geometry" />
        </mxCell>
        <mxCell id="8AOcLPsy6JB6qDF-pSW3-71" connectable="0" parent="8AOcLPsy6JB6qDF-pSW3-70" style="edgeLabel;html=1;align=center;verticalAlign=middle;resizable=0;points=[];" value="posts" vertex="1">
          <mxGeometry relative="1" x="-0.0903" y="-2" as="geometry">
            <mxPoint as="offset" />
          </mxGeometry>
        </mxCell>
        <mxCell id="8AOcLPsy6JB6qDF-pSW3-7" parent="1" style="swimlane;whiteSpace=wrap;html=1;" value="Employer" vertex="1">
          <mxGeometry height="250" width="200" x="750" y="920" as="geometry">
            <mxRectangle height="30" width="90" x="260" y="80" as="alternateBounds" />
          </mxGeometry>
        </mxCell>
        <mxCell id="8AOcLPsy6JB6qDF-pSW3-21" parent="8AOcLPsy6JB6qDF-pSW3-7" style="text;html=1;whiteSpace=wrap;strokeColor=none;fillColor=none;align=center;verticalAlign=middle;rounded=0;" value="&lt;div align=&quot;left&quot;&gt;&lt;span&gt;-&amp;nbsp;&lt;/span&gt;&lt;span&gt;companyName: String&lt;/span&gt;&lt;/div&gt;&lt;div align=&quot;left&quot;&gt;&lt;span&gt;-&amp;nbsp;&lt;/span&gt;&lt;span&gt;companyWebsite: String&lt;/span&gt;&lt;/div&gt;&lt;div align=&quot;left&quot;&gt;&lt;span&gt;-&amp;nbsp;&lt;/span&gt;&lt;span&gt;companySize: String&lt;/span&gt;&lt;/div&gt;&lt;div align=&quot;left&quot;&gt;&lt;span&gt;-&amp;nbsp;&lt;/span&gt;&lt;span&gt;industry: String&lt;/span&gt;&lt;/div&gt;&lt;div align=&quot;left&quot;&gt;&lt;span&gt;-&amp;nbsp;&lt;/span&gt;&lt;span&gt;companyLogo: String&lt;/span&gt;&lt;/div&gt;&lt;div align=&quot;left&quot;&gt;&lt;span&gt;-&amp;nbsp;&lt;/span&gt;&lt;span&gt;companyDescription: String&lt;/span&gt;&lt;/div&gt;&lt;div align=&quot;left&quot;&gt;&lt;span&gt;- companyHeadquarters: String&lt;/span&gt;&lt;/div&gt;&lt;br&gt;&lt;div&gt;&lt;span&gt;&lt;br&gt;&lt;/span&gt;&lt;/div&gt;" vertex="1">
          <mxGeometry height="120" width="170" x="15" y="40" as="geometry" />
        </mxCell>
        <mxCell id="8AOcLPsy6JB6qDF-pSW3-22" edge="1" parent="8AOcLPsy6JB6qDF-pSW3-7" style="endArrow=none;html=1;rounded=0;" value="">
          <mxGeometry height="50" relative="1" width="50" as="geometry">
            <mxPoint y="142.57" as="sourcePoint" />
            <mxPoint x="200" y="142.57" as="targetPoint" />
          </mxGeometry>
        </mxCell>
        <mxCell id="8AOcLPsy6JB6qDF-pSW3-23" parent="8AOcLPsy6JB6qDF-pSW3-7" style="text;html=1;whiteSpace=wrap;strokeColor=none;fillColor=none;align=center;verticalAlign=middle;rounded=0;" value="&lt;div align=&quot;left&quot;&gt;&lt;span&gt;+ postJob&lt;/span&gt;&lt;span&gt;()&lt;/span&gt;&lt;/div&gt;&lt;div align=&quot;left&quot;&gt;&lt;span&gt;+&amp;nbsp;&lt;/span&gt;&lt;span&gt;editJobPosting()&lt;/span&gt;&lt;/div&gt;&lt;div align=&quot;left&quot;&gt;&lt;span&gt;+&amp;nbsp;&lt;/span&gt;&lt;span&gt;deleteJobPosting()&lt;/span&gt;&lt;/div&gt;&lt;div align=&quot;left&quot;&gt;&lt;span&gt;+&amp;nbsp;&lt;/span&gt;&lt;span&gt;viewApplications()&lt;/span&gt;&lt;/div&gt;&lt;div align=&quot;left&quot;&gt;&lt;div align=&quot;left&quot;&gt;&lt;span&gt;+&amp;nbsp;&lt;/span&gt;&lt;span&gt;searchCandidates()&amp;nbsp;&lt;/span&gt;&lt;/div&gt;&lt;div align=&quot;left&quot;&gt;&lt;span&gt;+&amp;nbsp;&lt;/span&gt;&lt;span&gt;updateEmployerProfile()&lt;/span&gt;&lt;/div&gt;&lt;br&gt;&lt;/div&gt;&lt;br&gt;&lt;div&gt;&lt;span&gt;&lt;br&gt;&lt;/span&gt;&lt;/div&gt;" vertex="1">
          <mxGeometry height="120" width="170" x="10" y="160" as="geometry" />
        </mxCell>
        <mxCell id="8AOcLPsy6JB6qDF-pSW3-48" edge="1" parent="1" source="8AOcLPsy6JB6qDF-pSW3-8" style="rounded=0;orthogonalLoop=1;jettySize=auto;html=1;exitX=1;exitY=0.25;exitDx=0;exitDy=0;entryX=0;entryY=0.25;entryDx=0;entryDy=0;shape=link;width=0;" target="8AOcLPsy6JB6qDF-pSW3-11">
          <mxGeometry relative="1" as="geometry" />
        </mxCell>
        <mxCell id="8AOcLPsy6JB6qDF-pSW3-49" connectable="0" parent="8AOcLPsy6JB6qDF-pSW3-48" style="edgeLabel;html=1;align=center;verticalAlign=middle;resizable=0;points=[];" value="has" vertex="1">
          <mxGeometry relative="1" x="0.0154" y="1" as="geometry">
            <mxPoint as="offset" />
          </mxGeometry>
        </mxCell>
        <mxCell id="8AOcLPsy6JB6qDF-pSW3-60" edge="1" parent="1" source="8AOcLPsy6JB6qDF-pSW3-8" style="edgeStyle=orthogonalEdgeStyle;rounded=0;orthogonalLoop=1;jettySize=auto;html=1;exitX=0;exitY=0.5;exitDx=0;exitDy=0;entryX=1;entryY=0.25;entryDx=0;entryDy=0;" target="8AOcLPsy6JB6qDF-pSW3-5">
          <mxGeometry relative="1" as="geometry" />
        </mxCell>
        <mxCell id="8AOcLPsy6JB6qDF-pSW3-62" edge="1" parent="1" source="8AOcLPsy6JB6qDF-pSW3-8" style="rounded=0;orthogonalLoop=1;jettySize=auto;html=1;shape=link;width=-0.5263157894736832;entryX=0;entryY=0.25;entryDx=0;entryDy=0;exitX=1;exitY=0.75;exitDx=0;exitDy=0;" target="8AOcLPsy6JB6qDF-pSW3-10">
          <mxGeometry relative="1" as="geometry">
            <mxPoint x="900" y="400" as="sourcePoint" />
            <mxPoint x="1010" y="480" as="targetPoint" />
          </mxGeometry>
        </mxCell>
        <mxCell id="8AOcLPsy6JB6qDF-pSW3-63" connectable="0" parent="8AOcLPsy6JB6qDF-pSW3-62" style="edgeLabel;html=1;align=center;verticalAlign=middle;resizable=0;points=[];" value="has" vertex="1">
          <mxGeometry relative="1" x="0.0127" y="-1" as="geometry">
            <mxPoint as="offset" />
          </mxGeometry>
        </mxCell>
        <mxCell id="8AOcLPsy6JB6qDF-pSW3-8" parent="1" style="swimlane;whiteSpace=wrap;html=1;" value="JobSeeker" vertex="1">
          <mxGeometry height="290" width="200" x="710" y="90" as="geometry">
            <mxRectangle height="30" width="100" x="510" y="80" as="alternateBounds" />
          </mxGeometry>
        </mxCell>
        <mxCell id="8AOcLPsy6JB6qDF-pSW3-24" parent="8AOcLPsy6JB6qDF-pSW3-8" style="text;html=1;whiteSpace=wrap;strokeColor=none;fillColor=none;align=center;verticalAlign=middle;rounded=0;" value="&lt;div align=&quot;left&quot;&gt;&lt;span&gt;- headline: String&lt;/span&gt;&lt;/div&gt;&lt;div align=&quot;left&quot;&gt;&lt;span&gt;-&amp;nbsp;&lt;/span&gt;&lt;span&gt;summary: String&lt;/span&gt;&lt;/div&gt;&lt;div align=&quot;left&quot;&gt;&lt;span&gt;-&amp;nbsp;&lt;/span&gt;&lt;span&gt;resume: File&lt;/span&gt;&lt;/div&gt;&lt;div align=&quot;left&quot;&gt;&lt;span&gt;-&amp;nbsp;&lt;/span&gt;&lt;span&gt;skills: List&lt;/span&gt;&lt;span class=&quot;ds-markdown-html&quot;&gt;&amp;lt;Skill&amp;gt;&lt;/span&gt;&lt;/div&gt;&lt;div align=&quot;left&quot;&gt;&lt;span&gt;-&amp;nbsp;&lt;/span&gt;&lt;span&gt;education: List&lt;/span&gt;&lt;span class=&quot;ds-markdown-html&quot;&gt;&amp;lt;Education&amp;gt;&lt;/span&gt;&lt;/div&gt;&lt;div align=&quot;left&quot;&gt;&lt;br&gt;&lt;/div&gt;&lt;div align=&quot;left&quot;&gt;&lt;br&gt;&lt;/div&gt;&lt;br&gt;&lt;div&gt;&lt;span&gt;&lt;br&gt;&lt;/span&gt;&lt;/div&gt;" vertex="1">
          <mxGeometry height="120" width="190" x="5" y="40" as="geometry" />
        </mxCell>
        <mxCell id="8AOcLPsy6JB6qDF-pSW3-25" edge="1" parent="8AOcLPsy6JB6qDF-pSW3-8" style="endArrow=none;html=1;rounded=0;" value="">
          <mxGeometry height="50" relative="1" width="50" as="geometry">
            <mxPoint y="134.57" as="sourcePoint" />
            <mxPoint x="200" y="134.57" as="targetPoint" />
          </mxGeometry>
        </mxCell>
        <mxCell id="8AOcLPsy6JB6qDF-pSW3-26" parent="8AOcLPsy6JB6qDF-pSW3-8" style="text;html=1;whiteSpace=wrap;strokeColor=none;fillColor=none;align=center;verticalAlign=middle;rounded=0;" value="&lt;div align=&quot;left&quot;&gt;&lt;span&gt;+&amp;nbsp;&lt;/span&gt;&lt;span&gt;applyForJob()&lt;/span&gt;&lt;/div&gt;&lt;div align=&quot;left&quot;&gt;&lt;span&gt;+&amp;nbsp;&lt;/span&gt;&lt;span&gt;saveJob()&lt;/span&gt;&lt;/div&gt;&lt;div align=&quot;left&quot;&gt;&lt;span&gt;+&amp;nbsp;&lt;/span&gt;&lt;span&gt;uploadResume()&lt;/span&gt;&lt;/div&gt;&lt;div align=&quot;left&quot;&gt;&lt;span&gt;+&amp;nbsp;&lt;/span&gt;&lt;span&gt;addEducation()&lt;/span&gt;&lt;/div&gt;&lt;div align=&quot;left&quot;&gt;&lt;div align=&quot;left&quot;&gt;&lt;span&gt;+&amp;nbsp;&lt;/span&gt;&lt;span&gt;addExperience()&lt;/span&gt;&lt;/div&gt;&lt;div align=&quot;left&quot;&gt;&lt;span&gt;+&amp;nbsp;&lt;/span&gt;&lt;span&gt;viewApplicationStatus()&lt;/span&gt;&lt;/div&gt;&lt;div align=&quot;left&quot;&gt;&lt;span&gt;+&amp;nbsp;&lt;/span&gt;&lt;span&gt;viewCompanyProfile()&lt;/span&gt;&lt;/div&gt;&lt;div align=&quot;left&quot;&gt;&lt;span&gt;+&amp;nbsp;&lt;/span&gt;&lt;span&gt;searchJobs()&lt;/span&gt;&lt;/div&gt;&lt;br&gt;&lt;/div&gt;&lt;br&gt;&lt;div&gt;&lt;span&gt;&lt;br&gt;&lt;/span&gt;&lt;/div&gt;" vertex="1">
          <mxGeometry height="110" width="170" x="15" y="180" as="geometry" />
        </mxCell>
        <mxCell id="8AOcLPsy6JB6qDF-pSW3-66" edge="1" parent="1" source="8AOcLPsy6JB6qDF-pSW3-9" style="rounded=0;orthogonalLoop=1;jettySize=auto;html=1;exitX=0.75;exitY=0;exitDx=0;exitDy=0;entryX=0.75;entryY=1;entryDx=0;entryDy=0;shape=link;width=0;" target="8AOcLPsy6JB6qDF-pSW3-8">
          <mxGeometry relative="1" as="geometry" />
        </mxCell>
        <mxCell id="8AOcLPsy6JB6qDF-pSW3-67" connectable="0" parent="8AOcLPsy6JB6qDF-pSW3-66" style="edgeLabel;html=1;align=center;verticalAlign=middle;resizable=0;points=[];" value="looks for" vertex="1">
          <mxGeometry relative="1" x="-0.079" y="-1" as="geometry">
            <mxPoint x="-1" as="offset" />
          </mxGeometry>
        </mxCell>
        <mxCell id="8AOcLPsy6JB6qDF-pSW3-9" parent="1" style="swimlane;whiteSpace=wrap;html=1;" value="Job" vertex="1">
          <mxGeometry height="320" width="230" x="730" y="480" as="geometry">
            <mxRectangle height="30" width="60" x="600" y="220" as="alternateBounds" />
          </mxGeometry>
        </mxCell>
        <mxCell id="8AOcLPsy6JB6qDF-pSW3-27" parent="8AOcLPsy6JB6qDF-pSW3-9" style="text;html=1;whiteSpace=wrap;strokeColor=none;fillColor=none;align=center;verticalAlign=middle;rounded=0;" value="&lt;div align=&quot;left&quot;&gt;&lt;span&gt;-&amp;nbsp;&lt;/span&gt;&lt;span&gt;jobId: String&lt;/span&gt;&lt;/div&gt;&lt;div align=&quot;left&quot;&gt;&lt;span&gt;-&amp;nbsp;&lt;/span&gt;&lt;span&gt;title: String&lt;/span&gt;&lt;/div&gt;&lt;div align=&quot;left&quot;&gt;&lt;span&gt;-&amp;nbsp;&lt;/span&gt;&lt;span&gt;description: String&lt;/span&gt;&lt;/div&gt;&lt;div align=&quot;left&quot;&gt;&lt;span&gt;-&amp;nbsp;&lt;/span&gt;&lt;span&gt;requirements: List&lt;/span&gt;&lt;span class=&quot;ds-markdown-html&quot;&gt;&amp;lt;String&amp;gt;&lt;/span&gt;&lt;/div&gt;&lt;div align=&quot;left&quot;&gt;&lt;span&gt;-&amp;nbsp;&lt;/span&gt;&lt;span&gt;responsibilities: List&lt;/span&gt;&lt;span class=&quot;ds-markdown-html&quot;&gt;&amp;lt;String&amp;gt;&lt;/span&gt;&lt;/div&gt;&lt;div align=&quot;left&quot;&gt;&lt;span&gt;-&amp;nbsp;&lt;/span&gt;&lt;span&gt;location: String&lt;/span&gt;&lt;/div&gt;&lt;div align=&quot;left&quot;&gt;&lt;span&gt;-&amp;nbsp;&lt;/span&gt;&lt;span&gt;remoteOption: Boolean&lt;/span&gt;&lt;/div&gt;&lt;div align=&quot;left&quot;&gt;&lt;span&gt;-&amp;nbsp;&lt;/span&gt;&lt;span&gt;salaryRange: String&lt;/span&gt;&lt;/div&gt;&lt;div align=&quot;left&quot;&gt;&lt;span&gt;-&amp;nbsp;&lt;/span&gt;&lt;span&gt;employmentType: EmploymentType&lt;/span&gt;&lt;/div&gt;&lt;div align=&quot;left&quot;&gt;&lt;div align=&quot;left&quot;&gt;&lt;span&gt;-&amp;nbsp;&lt;/span&gt;&lt;span&gt;deadlineDate: Date&lt;/span&gt;&lt;/div&gt;&lt;div align=&quot;left&quot;&gt;&lt;span&gt;-&amp;nbsp;&lt;/span&gt;&lt;span&gt;status: JobStatus&lt;/span&gt;&lt;/div&gt;&lt;br&gt;&lt;span&gt;&lt;br&gt;&lt;/span&gt;&lt;/div&gt;&lt;div&gt;&lt;span&gt;&lt;br&gt;&lt;/span&gt;&lt;/div&gt;" vertex="1">
          <mxGeometry height="150" width="200" x="15" y="60" as="geometry" />
        </mxCell>
        <mxCell id="8AOcLPsy6JB6qDF-pSW3-28" edge="1" parent="8AOcLPsy6JB6qDF-pSW3-9" style="endArrow=none;html=1;rounded=0;" value="">
          <mxGeometry height="50" relative="1" width="50" as="geometry">
            <mxPoint y="210" as="sourcePoint" />
            <mxPoint x="230" y="210" as="targetPoint" />
          </mxGeometry>
        </mxCell>
        <mxCell id="8AOcLPsy6JB6qDF-pSW3-29" parent="8AOcLPsy6JB6qDF-pSW3-9" style="text;html=1;whiteSpace=wrap;strokeColor=none;fillColor=none;align=center;verticalAlign=middle;rounded=0;" value="&lt;br&gt;&lt;div align=&quot;left&quot;&gt;&lt;span&gt;+ create()&lt;/span&gt;&lt;/div&gt;&lt;div align=&quot;left&quot;&gt;&lt;span&gt;+ read()&lt;/span&gt;&lt;/div&gt;&lt;div align=&quot;left&quot;&gt;&lt;span&gt;+&amp;nbsp;&lt;/span&gt;&lt;span&gt;update()&lt;/span&gt;&lt;/div&gt;&lt;div align=&quot;left&quot;&gt;&lt;span&gt;+&amp;nbsp;&lt;/span&gt;&lt;span&gt;delete()&lt;/span&gt;&lt;/div&gt;&lt;div align=&quot;left&quot;&gt;&lt;span&gt;+ findJobs&lt;/span&gt;&lt;/div&gt;&lt;div align=&quot;left&quot;&gt;+ findOpenPositions&lt;/div&gt;&lt;div align=&quot;left&quot;&gt;&lt;br&gt;&lt;/div&gt;&lt;div align=&quot;left&quot;&gt;&lt;br&gt;&lt;/div&gt;&lt;br&gt;&lt;div&gt;&lt;span&gt;&lt;br&gt;&lt;/span&gt;&lt;/div&gt;" vertex="1">
          <mxGeometry height="110" width="170" y="230" as="geometry" />
        </mxCell>
        <mxCell id="8AOcLPsy6JB6qDF-pSW3-10" parent="1" style="swimlane;whiteSpace=wrap;html=1;startSize=23;" value="Skill" vertex="1">
          <mxGeometry height="170" width="200" x="1085" y="420" as="geometry">
            <mxRectangle height="30" width="60" x="25" y="420" as="alternateBounds" />
          </mxGeometry>
        </mxCell>
        <mxCell id="8AOcLPsy6JB6qDF-pSW3-30" parent="8AOcLPsy6JB6qDF-pSW3-10" style="text;html=1;whiteSpace=wrap;strokeColor=none;fillColor=none;align=center;verticalAlign=middle;rounded=0;" value="&lt;div align=&quot;left&quot;&gt;&lt;span&gt;-&amp;nbsp;&lt;/span&gt;&lt;span&gt;name: String&lt;/span&gt;&lt;/div&gt;&lt;div align=&quot;left&quot;&gt;&lt;span&gt;-&amp;nbsp;&lt;/span&gt;&lt;span&gt;yearsOfExperience: float&lt;/span&gt;&lt;/div&gt;&lt;div align=&quot;left&quot;&gt;&lt;div align=&quot;left&quot;&gt;&lt;span&gt;- category&lt;/span&gt;&lt;span&gt;: String&lt;/span&gt;&lt;/div&gt;&lt;div align=&quot;left&quot;&gt;&lt;span&gt;-&amp;nbsp;&lt;/span&gt;&lt;span&gt;skillID: String&lt;/span&gt;&lt;/div&gt;&lt;br&gt;&lt;/div&gt;&lt;br&gt;&lt;div align=&quot;left&quot;&gt;&lt;br&gt;&lt;/div&gt;&lt;br&gt;&lt;div&gt;&lt;span&gt;&lt;br&gt;&lt;/span&gt;&lt;/div&gt;" vertex="1">
          <mxGeometry height="110" width="185" x="-15" y="40" as="geometry" />
        </mxCell>
        <mxCell id="8AOcLPsy6JB6qDF-pSW3-32" edge="1" parent="8AOcLPsy6JB6qDF-pSW3-10" style="endArrow=none;html=1;rounded=0;" value="">
          <mxGeometry height="50" relative="1" width="50" as="geometry">
            <mxPoint x="2.5" y="100" as="sourcePoint" />
            <mxPoint x="197.5" y="100" as="targetPoint" />
          </mxGeometry>
        </mxCell>
        <mxCell id="8AOcLPsy6JB6qDF-pSW3-33" parent="8AOcLPsy6JB6qDF-pSW3-10" style="text;html=1;whiteSpace=wrap;strokeColor=none;fillColor=none;align=center;verticalAlign=middle;rounded=0;" value="&lt;div align=&quot;left&quot;&gt;&lt;span&gt;+&amp;nbsp;&lt;/span&gt;&lt;span&gt;addSkill()&lt;/span&gt;&lt;/div&gt;&lt;div align=&quot;left&quot;&gt;&lt;span&gt;+&amp;nbsp;&lt;/span&gt;&lt;span&gt;updateSkill()&lt;/span&gt;&lt;/div&gt;&lt;div align=&quot;left&quot;&gt;&lt;span&gt;+&amp;nbsp;&lt;/span&gt;&lt;span&gt;removeSkill()&lt;/span&gt;&lt;/div&gt;&lt;br&gt;&lt;div&gt;&lt;span&gt;&lt;br&gt;&lt;/span&gt;&lt;/div&gt;" vertex="1">
          <mxGeometry height="114" width="145" x="-15" y="90" as="geometry" />
        </mxCell>
        <mxCell id="8AOcLPsy6JB6qDF-pSW3-11" parent="1" style="swimlane;whiteSpace=wrap;html=1;" value="&lt;div&gt;Education&lt;/div&gt;" vertex="1">
          <mxGeometry height="220" width="190" x="1080" y="-90" as="geometry">
            <mxRectangle height="30" width="90" x="790" y="430" as="alternateBounds" />
          </mxGeometry>
        </mxCell>
        <mxCell id="8AOcLPsy6JB6qDF-pSW3-34" parent="8AOcLPsy6JB6qDF-pSW3-11" style="text;html=1;whiteSpace=wrap;strokeColor=none;fillColor=none;align=center;verticalAlign=middle;rounded=0;" value="&lt;div align=&quot;left&quot;&gt;&lt;span&gt;- educationID:String&lt;/span&gt;&lt;/div&gt;&lt;div align=&quot;left&quot;&gt;&lt;span&gt;-&amp;nbsp;&lt;/span&gt;&lt;span&gt;institution: String&lt;/span&gt;&lt;/div&gt;&lt;div align=&quot;left&quot;&gt;&lt;span&gt;-&amp;nbsp;&lt;/span&gt;&lt;span&gt;degree: String&lt;/span&gt;&lt;/div&gt;&lt;div align=&quot;left&quot;&gt;&lt;span&gt;-&amp;nbsp;&lt;/span&gt;&lt;span&gt;fieldOfStudy: String&lt;/span&gt;&lt;/div&gt;&lt;div align=&quot;left&quot;&gt;&lt;span&gt;-&amp;nbsp;&lt;/span&gt;&lt;span&gt;startDate: Date&lt;/span&gt;&lt;/div&gt;&lt;div align=&quot;left&quot;&gt;&lt;span&gt;-&amp;nbsp;&lt;/span&gt;&lt;span&gt;endDate: Date&lt;/span&gt;&lt;/div&gt;&lt;div align=&quot;left&quot;&gt;&lt;span&gt;-&amp;nbsp;&lt;/span&gt;&lt;span&gt;description: String&lt;/span&gt;&lt;/div&gt;&lt;div align=&quot;left&quot;&gt;&lt;br&gt;&lt;span&gt;&lt;br&gt;&lt;/span&gt;&lt;/div&gt;&lt;div&gt;&lt;span&gt;&lt;br&gt;&lt;/span&gt;&lt;/div&gt;" vertex="1">
          <mxGeometry height="150" width="120" x="10" y="30" as="geometry" />
        </mxCell>
        <mxCell id="8AOcLPsy6JB6qDF-pSW3-35" edge="1" parent="8AOcLPsy6JB6qDF-pSW3-11" style="endArrow=none;html=1;rounded=0;" value="">
          <mxGeometry height="50" relative="1" width="50" as="geometry">
            <mxPoint y="140" as="sourcePoint" />
            <mxPoint x="190" y="140" as="targetPoint" />
          </mxGeometry>
        </mxCell>
        <mxCell id="8AOcLPsy6JB6qDF-pSW3-36" parent="8AOcLPsy6JB6qDF-pSW3-11" style="text;html=1;whiteSpace=wrap;strokeColor=none;fillColor=none;align=center;verticalAlign=middle;rounded=0;" value="&lt;div align=&quot;left&quot;&gt;&lt;span&gt;+&amp;nbsp;&lt;/span&gt;&lt;span&gt;addEducation()&lt;/span&gt;&lt;/div&gt;&lt;div align=&quot;left&quot;&gt;&lt;span&gt;+&amp;nbsp;&lt;/span&gt;&lt;span&gt;updateEducation()&lt;/span&gt;&lt;/div&gt;&lt;div align=&quot;left&quot;&gt;&lt;span&gt;+&amp;nbsp;&lt;/span&gt;&lt;span&gt;removeEducation()&lt;/span&gt;&lt;/div&gt;&lt;div align=&quot;left&quot;&gt;&lt;span&gt;+ findByInstitution()&lt;/span&gt;&lt;/div&gt;&lt;div align=&quot;left&quot;&gt;&lt;span&gt;+ findByDegree()&lt;/span&gt;&lt;/div&gt;&lt;br&gt;&lt;div&gt;&lt;span&gt;&lt;br&gt;&lt;/span&gt;&lt;/div&gt;" vertex="1">
          <mxGeometry height="110" width="170" x="-10" y="140" as="geometry" />
        </mxCell>
        <mxCell id="8AOcLPsy6JB6qDF-pSW3-12" parent="1" style="swimlane;whiteSpace=wrap;html=1;" value="Experience" vertex="1">
          <mxGeometry height="196" width="200" x="1085" y="170" as="geometry">
            <mxRectangle height="30" width="100" x="610" y="450" as="alternateBounds" />
          </mxGeometry>
        </mxCell>
        <mxCell id="8AOcLPsy6JB6qDF-pSW3-37" parent="8AOcLPsy6JB6qDF-pSW3-12" style="text;html=1;whiteSpace=wrap;strokeColor=none;fillColor=none;align=center;verticalAlign=middle;rounded=0;" value="&lt;div align=&quot;left&quot;&gt;&lt;span&gt;- experienceID: String&lt;/span&gt;&lt;/div&gt;&lt;div align=&quot;left&quot;&gt;&lt;span&gt;-&amp;nbsp;&lt;/span&gt;&lt;span&gt;jobTitle: String&lt;/span&gt;&lt;/div&gt;&lt;div align=&quot;left&quot;&gt;&lt;span&gt;-&amp;nbsp;&lt;/span&gt;&lt;span&gt;company: String&lt;/span&gt;&lt;/div&gt;&lt;div align=&quot;left&quot;&gt;&lt;span&gt;-&amp;nbsp;&lt;/span&gt;&lt;span&gt;location: String&lt;/span&gt;&lt;/div&gt;&lt;div align=&quot;left&quot;&gt;&lt;span&gt;-&amp;nbsp;&lt;/span&gt;&lt;span&gt;startDate: Date&lt;/span&gt;&lt;/div&gt;&lt;div align=&quot;left&quot;&gt;&lt;span&gt;-&amp;nbsp;&lt;/span&gt;&lt;span&gt;endDate: Date&lt;/span&gt;&lt;/div&gt;&lt;div align=&quot;left&quot;&gt;&lt;span&gt;-&amp;nbsp;&lt;/span&gt;&lt;span&gt;description: String&lt;/span&gt;&lt;/div&gt;&lt;div align=&quot;left&quot;&gt;&lt;br&gt;&lt;span&gt;&lt;br&gt;&lt;/span&gt;&lt;/div&gt;&lt;div&gt;&lt;span&gt;&lt;br&gt;&lt;/span&gt;&lt;/div&gt;" vertex="1">
          <mxGeometry height="150" width="120" x="10" y="25" as="geometry" />
        </mxCell>
        <mxCell id="8AOcLPsy6JB6qDF-pSW3-38" edge="1" parent="8AOcLPsy6JB6qDF-pSW3-12" style="endArrow=none;html=1;rounded=0;" value="">
          <mxGeometry height="50" relative="1" width="50" as="geometry">
            <mxPoint y="136" as="sourcePoint" />
            <mxPoint x="200" y="136" as="targetPoint" />
          </mxGeometry>
        </mxCell>
        <mxCell id="8AOcLPsy6JB6qDF-pSW3-39" parent="8AOcLPsy6JB6qDF-pSW3-12" style="text;html=1;whiteSpace=wrap;strokeColor=none;fillColor=none;align=center;verticalAlign=middle;rounded=0;" value="&lt;div align=&quot;left&quot;&gt;&lt;span&gt;+&amp;nbsp;&lt;/span&gt;&lt;span&gt;addExperience()&lt;/span&gt;&lt;/div&gt;&lt;div align=&quot;left&quot;&gt;&lt;span&gt;+&amp;nbsp;&lt;/span&gt;&lt;span&gt;updateExperience()&lt;/span&gt;&lt;/div&gt;&lt;div align=&quot;left&quot;&gt;&lt;span&gt;+&amp;nbsp;&lt;/span&gt;&lt;span&gt;removeExperience()&lt;/span&gt;&lt;/div&gt;&lt;div align=&quot;left&quot;&gt;&lt;div align=&quot;left&quot;&gt;&lt;span&gt;&amp;nbsp;&lt;/span&gt;&lt;/div&gt;&lt;br&gt;&lt;/div&gt;&lt;br&gt;&lt;div&gt;&lt;span&gt;&lt;br&gt;&lt;/span&gt;&lt;/div&gt;" vertex="1">
          <mxGeometry height="104" width="170" x="-10" y="146" as="geometry" />
        </mxCell>
        <mxCell id="8AOcLPsy6JB6qDF-pSW3-13" parent="1" style="swimlane;whiteSpace=wrap;html=1;startSize=23;" value="EmploymentType" vertex="1">
          <mxGeometry height="140" width="200" x="1085" y="640" as="geometry">
            <mxRectangle height="30" width="130" x="440" y="450" as="alternateBounds" />
          </mxGeometry>
        </mxCell>
        <mxCell id="8AOcLPsy6JB6qDF-pSW3-40" parent="8AOcLPsy6JB6qDF-pSW3-13" style="text;html=1;whiteSpace=wrap;strokeColor=none;fillColor=none;align=center;verticalAlign=middle;rounded=0;" value="&lt;div align=&quot;left&quot;&gt;&lt;span&gt;-&amp;nbsp;&lt;/span&gt;&lt;span&gt;type: String&lt;/span&gt;&lt;/div&gt;&lt;br&gt;&lt;div&gt;&lt;span&gt;&lt;br&gt;&lt;/span&gt;&lt;/div&gt;" vertex="1">
          <mxGeometry height="56" width="90" y="30" as="geometry" />
        </mxCell>
        <mxCell id="8AOcLPsy6JB6qDF-pSW3-41" edge="1" parent="8AOcLPsy6JB6qDF-pSW3-13" style="endArrow=none;html=1;rounded=0;" value="">
          <mxGeometry height="50" relative="1" width="50" as="geometry">
            <mxPoint y="69.51999999999998" as="sourcePoint" />
            <mxPoint x="200" y="69.51999999999998" as="targetPoint" />
          </mxGeometry>
        </mxCell>
        <mxCell id="8AOcLPsy6JB6qDF-pSW3-46" edge="1" parent="1" source="8AOcLPsy6JB6qDF-pSW3-8" style="edgeStyle=none;orthogonalLoop=1;jettySize=auto;html=1;rounded=0;exitX=1;exitY=0.5;exitDx=0;exitDy=0;entryX=0;entryY=0.5;entryDx=0;entryDy=0;shape=link;width=0;" target="8AOcLPsy6JB6qDF-pSW3-12" value="">
          <mxGeometry relative="1" width="80" as="geometry">
            <mxPoint x="920" y="270" as="sourcePoint" />
            <mxPoint x="1000" y="270" as="targetPoint" />
          </mxGeometry>
        </mxCell>
        <mxCell id="8AOcLPsy6JB6qDF-pSW3-50" connectable="0" parent="8AOcLPsy6JB6qDF-pSW3-46" style="edgeLabel;html=1;align=center;verticalAlign=middle;resizable=0;points=[];" value="has" vertex="1">
          <mxGeometry relative="1" x="0.0566" y="-1" as="geometry">
            <mxPoint as="offset" />
          </mxGeometry>
        </mxCell>
        <mxCell id="8AOcLPsy6JB6qDF-pSW3-51" parent="1" style="text;html=1;whiteSpace=wrap;strokeColor=none;fillColor=none;align=center;verticalAlign=middle;rounded=0;" value="1" vertex="1">
          <mxGeometry height="30" width="40" x="900" y="160" as="geometry" />
        </mxCell>
        <mxCell id="8AOcLPsy6JB6qDF-pSW3-52" parent="1" style="text;html=1;whiteSpace=wrap;strokeColor=none;fillColor=none;align=center;verticalAlign=middle;rounded=0;" value="0...*" vertex="1">
          <mxGeometry height="30" width="40" x="1040" y="-70" as="geometry" />
        </mxCell>
        <mxCell id="8AOcLPsy6JB6qDF-pSW3-53" parent="1" style="text;html=1;whiteSpace=wrap;strokeColor=none;fillColor=none;align=center;verticalAlign=middle;rounded=0;" value="1" vertex="1">
          <mxGeometry height="30" width="40" x="900" y="240" as="geometry" />
        </mxCell>
        <mxCell id="8AOcLPsy6JB6qDF-pSW3-54" parent="1" style="text;html=1;whiteSpace=wrap;strokeColor=none;fillColor=none;align=center;verticalAlign=middle;rounded=0;" value="0...*" vertex="1">
          <mxGeometry height="30" width="40" x="1040" y="210" as="geometry" />
        </mxCell>
        <mxCell id="8AOcLPsy6JB6qDF-pSW3-64" parent="1" style="text;html=1;whiteSpace=wrap;strokeColor=none;fillColor=none;align=center;verticalAlign=middle;rounded=0;" value="1" vertex="1">
          <mxGeometry height="30" width="40" x="900" y="320" as="geometry" />
        </mxCell>
        <mxCell id="8AOcLPsy6JB6qDF-pSW3-65" parent="1" style="text;html=1;whiteSpace=wrap;strokeColor=none;fillColor=none;align=center;verticalAlign=middle;rounded=0;" value="0...*" vertex="1">
          <mxGeometry height="30" width="40" x="1045" y="460" as="geometry" />
        </mxCell>
        <mxCell id="8AOcLPsy6JB6qDF-pSW3-68" parent="1" style="text;html=1;whiteSpace=wrap;strokeColor=none;fillColor=none;align=center;verticalAlign=middle;rounded=0;" value="1" vertex="1">
          <mxGeometry height="30" width="40" x="830" y="380" as="geometry" />
        </mxCell>
        <mxCell id="8AOcLPsy6JB6qDF-pSW3-69" parent="1" style="text;html=1;whiteSpace=wrap;strokeColor=none;fillColor=none;align=center;verticalAlign=middle;rounded=0;" value="0...*" vertex="1">
          <mxGeometry height="30" width="40" x="900" y="450" as="geometry" />
        </mxCell>
        <mxCell id="8AOcLPsy6JB6qDF-pSW3-72" parent="1" style="text;html=1;whiteSpace=wrap;strokeColor=none;fillColor=none;align=center;verticalAlign=middle;rounded=0;" value="1" vertex="1">
          <mxGeometry height="30" width="40" x="890" y="890" as="geometry" />
        </mxCell>
        <mxCell id="8AOcLPsy6JB6qDF-pSW3-73" parent="1" style="text;html=1;whiteSpace=wrap;strokeColor=none;fillColor=none;align=center;verticalAlign=middle;rounded=0;" value="0...*" vertex="1">
          <mxGeometry height="30" width="40" x="900" y="800" as="geometry" />
        </mxCell>
      </root>
    </mxGraphModel>
  </diagram>
</mxfile>
