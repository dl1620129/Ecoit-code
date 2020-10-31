package elegal.utils;

import java.util.ArrayList;
import java.util.List;

import com.ecoit.elegaldocument.model.LegalSuggestDocument;
import com.liferay.portal.kernel.util.HtmlUtil;

import elegal.object.SuggestObject;

public class SuggestionUtil {

	public static List<SuggestObject> appendDataToObject(List<LegalSuggestDocument> suggestionsList) {
		List<SuggestObject> objectsList = new ArrayList<>();
		for (LegalSuggestDocument suggestion: suggestionsList) {
			SuggestObject object = new SuggestObject();
			object.setSugId(suggestion.getSugId());
			object.setDocId(suggestion.getDocId());
			object.setUserName(HtmlUtil.extractText(suggestion.getVisitorName()));
			object.setEmail(HtmlUtil.extractText(suggestion.getVisitorEmail()));
			object.setTitle(HtmlUtil.extractText(suggestion.getTitle()));
			object.setContent(HtmlUtil.extractText(suggestion.getContent()));
			object.setApproved(suggestion.isApproved());
			object.setCreatedDate(suggestion.getCreatedDate());
			objectsList.add(object);
		}
		return objectsList;
	}
}
